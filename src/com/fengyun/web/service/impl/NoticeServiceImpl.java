package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.dao.LawInsuDAO;
import com.fengyun.web.db.dao.NoticeDAO;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.MessageService;

import com.mongodb.BasicDBObject;

/**
 * 公告消息服务层
 * @author hsx
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 新增
	 */
	@Override
	public boolean addNotice(NoticeModel noticeModel) {
		return NoticeDAO.addNotice(noticeModel);
	}

	/**
	 * 获取所有的公告消息
	 */
	@Override
	public List<NoticeModel> getAllList() {
		return NoticeDAO.getAllList();
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public NoticeModel getById(String id) {
		return NoticeDAO.getById(id);
	}
	
	
	//////////////////////////////////////////////////////////////
	/**
	 * 后台公告列表分页
	 */
	@Override
	public List<NoticeModel> getNoticeList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return NoticeDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllNotice(BasicDBObject queryObj) {
		return NoticeDAO.countAll(queryObj);
	}

	/**
	 * 获取要做页面显示Notice信息
	 */
	@Override
	public Map<String, Object> getShowNoticeHasMap(String isRead,
			ModelAndView mav, String userId, String userType, String isLeader) {
		if ("0".equals(userType)) {
			if (isLeader != null) {
				if ("0".equals(isLeader) || "2".equals(isLeader)) {
					PersonModel personModel = personService.getByUserId(userId);
					if (personModel != null) {
						mav.addObject("personModel", personModel);
					}
				} else if ("1".equals(isLeader)) {
					TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
					if (teamModel != null) {
						mav.addObject("teamModel", teamModel);
					}
				}
			}
		} else if ("1".equals(userType)) {
			MaterialModel materialModel = materialService.getByUserId(userId);
			if (materialModel != null) {
				mav.addObject("materialModel", materialModel);
			}
		} else if ("2".equals(userType)) {
			EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
			if (equipmentModel != null) {
				mav.addObject("equipmentModel", equipmentModel);
			}
		} else if ("3".equals(userType)) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		} else if ("4".equals(userType)) {
			ProjectModel projectModel = projectService.getByUserId(userId);
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
		}
		int pageNow = 1; 
		int pageCount = 0;
		int pageSize = 10; // 每页显示10条
		int dataCount = 0;
		if (request.getParameter("pageNowFirst") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
		}
		if (request.getParameter("pageNowPre") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
		}
		if (request.getParameter("pageNowNext") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
		}
		if (request.getParameter("pageNowLast") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
		}
		List<NoticeModel> nModels = NoticeDAO.getAllList();
		int unReadNoticeCount = 0; // 未读的公告信息记录数
		int readNoticeCount = 0; // 已读的公告信息记录数
		Date date = new Date();
		List<NoticeModel> unReadModels = new ArrayList<NoticeModel>(); 
		List<NoticeModel> readModels = new ArrayList<NoticeModel>();
		if (nModels != null && !nModels.isEmpty()) {
			for (NoticeModel noticeModel : nModels) {
				if (date.after(noticeModel.getBeginTime()) && date.before(noticeModel.getEndTime())) {
					NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(noticeModel.getId(), userId);
					if (noticeLogModel != null) {
						if (noticeLogModel.getReadTime() == null) {
							unReadNoticeCount++;
							unReadModels.add(noticeModel);
						} else {
							readNoticeCount++;
							readModels.add(noticeModel);
						}
					} 
				}
			}
		}
		if ("1".equals(isRead)) { 
			dataCount = readNoticeCount;
		} else if ("0".equals(isRead)) {
			dataCount = unReadNoticeCount; 
		}
		if (dataCount % pageSize == 0) {
			pageCount = (int) (dataCount / pageSize); 
		} else {
			pageCount = (int) (dataCount / pageSize + 1);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		if (page != null) {
			mav.addObject("page", page);
			List<NoticeModel> unReadNoticeModels = new ArrayList<NoticeModel>();
			List<NoticeModel> readNoticeModels = new ArrayList<NoticeModel>();
			if (pageNow * pageSize < dataCount) { 
				if ("0".equals(isRead)) {
					unReadNoticeModels = unReadModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				} else if ("1".equals(isRead)) {
					readNoticeModels = readModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				}
			} else {
				if ("0".equals(isRead)) {
					unReadNoticeModels = unReadModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				} else if ("1".equals(isRead)) {
					readNoticeModels = readModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				}
			}
			if (unReadNoticeModels != null && !unReadNoticeModels.isEmpty()) {
				mav.addObject("unReadNoticeModels", unReadNoticeModels);
			}
			if (readNoticeModels != null && !readNoticeModels.isEmpty()) {
				mav.addObject("readNoticeModels", readNoticeModels);
			}
		}
		mav.addObject("pageCount", pageCount);
		mav.addObject("isRead", isRead);
		mav.addObject("flag", 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("readNoticeCount", readNoticeCount);
		map.put("unReadNoticeCount", unReadNoticeCount);
		map.put("mav", mav);
		return map;
	}

	/**
	 * 获取某个公告的具体内容
	 */
	@Override
	public List<JSONObject> getNoticeInfo(String nId, String id, String userType, String isLeader) {
		if ("0".equals(userType)) {
			if (isLeader != null) {
				if ("0".equals(isLeader) || "2".equals(isLeader)) {
					PersonModel personModel = personService.getById(id);
					if (personModel != null) {
						NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, personModel.getUserId());
						if (noticeLogModel != null) {
							noticeLogModel.setReadTime(new Date());
							noticeLogService.updateNoticeLog(noticeLogModel);
						}
					}
				} else if ("1".equals(isLeader)) {
					TeamModel teamModel = teamService.getTeamById(id);
					if (teamModel != null) {
						NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, teamModel.getLeaderMobile());
						if (noticeLogModel != null) {
							noticeLogModel.setReadTime(new Date());
							noticeLogService.updateNoticeLog(noticeLogModel);
						}
					}
				}
			}
		} else if ("1".equals(userType)) {
			MaterialModel materialModel = materialService.getById(id);
			if (materialModel != null) {
				NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, materialModel.getUserId());
				if (noticeLogModel != null) {
					noticeLogModel.setReadTime(new Date());
					noticeLogService.updateNoticeLog(noticeLogModel);
				}
			}
		} else if ("2".equals(userType)) {
			EquipmentModel equipmentModel = equipmentService.getById(id);
			if (equipmentModel != null) {
				NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, equipmentModel.getUserId());
				if (noticeLogModel != null) {
					noticeLogModel.setReadTime(new Date());
					noticeLogService.updateNoticeLog(noticeLogModel);
				}
			}
		} else if ("3".equals(userType)) {
			CompanyModel companyModel = companyService.getById(id);
			if (companyModel != null) {
				NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, companyModel.getUserId());
				if (noticeLogModel != null) {
					noticeLogModel.setReadTime(new Date());
					noticeLogService.updateNoticeLog(noticeLogModel);
				}
			}
		} else if ("4".equals(userType)) {
			ProjectModel projectModel = projectService.getById(id);
			if (projectModel != null) {
				NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(nId, projectModel.getUserId());
				if (noticeLogModel != null) {
					noticeLogModel.setReadTime(new Date());
					noticeLogService.updateNoticeLog(noticeLogModel);
				}
			}
		}
		NoticeModel noticeModel = NoticeDAO.getById(nId);
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		JSONObject jsonObject = new JSONObject();
		if (noticeModel != null) {
			String noticeInfo = noticeModel.getNoticeInfo();
			jsonObject.put("noticeInfo", noticeInfo);
			jsonObjects.add(jsonObject);
		}
		return jsonObjects;
	}

	/**
	 * 登陆或注册时获取的消息的总数
	 */
	@Override
	public Map<String, String> getNMCount(String userId) {
		int count = 0;
		int unReadMessageCount = 0;
		int readMessageCount = 0;
		int unReadNoticeCount = 0;
		List<MessageModel> messageModels = messageService.getAllListByRUserId(userId); 
		if (messageModels != null && !messageModels.isEmpty()) {
			for (MessageModel messageModel : messageModels) {
				if ("0".equals(messageModel.getIsRead())) {
					unReadMessageCount++;
				} else if ("1".equals(messageModel.getIsRead())) {
					readMessageCount++;
				}
			}
		}
		List<NoticeModel> nModels = NoticeDAO.getAllList();
		List<NoticeLogModel> noticeLogModels = noticeLogService.getListByUserId(userId);
		NoticeLogModel nlModel = null;
		int noticeCount = 0;
		Date date = new Date();
		if (nModels != null && !nModels.isEmpty()) {
			for (NoticeModel noticeModel : nModels) {
				if (noticeModel.getBeginTime() != null && noticeModel.getEndTime() != null) {
					if (date.after(noticeModel.getBeginTime()) && date.before(noticeModel.getEndTime())) {
						if (noticeLogModels != null && !noticeLogModels.isEmpty()) {
							int noticeIsReadCount = 0;
							for (NoticeLogModel noticeLogModel : noticeLogModels) {
								if (!noticeModel.getId().equals(noticeLogModel.getNoticeId())) {
									noticeIsReadCount++;
								}
							}
							if (noticeIsReadCount == noticeLogModels.size()) {
								nlModel = new NoticeLogModel();
								nlModel.setNoticeId(noticeModel.getId());
								nlModel.setUserId(userId);
								noticeLogService.addNoticeLog(nlModel);
							}
						} else {
							nlModel = new NoticeLogModel();
							nlModel.setNoticeId(noticeModel.getId());
							nlModel.setUserId(userId);
							noticeLogService.addNoticeLog(nlModel);
						}
					}
				}
			}
		}
		if (nModels != null && !nModels.isEmpty()) {
			for (NoticeModel noticeModel : nModels) {
				if (noticeModel.getBeginTime() != null && noticeModel.getEndTime() != null) {
					if (date.after(noticeModel.getBeginTime()) && date.before(noticeModel.getEndTime())) {
						noticeCount++;
						NoticeLogModel noticeLogModel = noticeLogService.getByNoticeIdAndUserId(noticeModel.getId(), userId);
						if (noticeLogModel != null) {
							if (noticeLogModel.getReadTime() == null) {
								unReadNoticeCount++;
							}
						}
					}
				}
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("count", (unReadMessageCount + unReadNoticeCount) + "");
		map.put("unReadMessageCount", unReadMessageCount + "");
		map.put("readMessageCount", readMessageCount + "");
		map.put("unReadNoticeCount", unReadNoticeCount + "");
		map.put("readNoticeCount", (noticeCount - unReadNoticeCount) + "");
		return map;
	}

}
