package com.fengyun.web.controller;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

/**
 * 一对一消息和公告消息
 * @author hsx
 *
 */
@Controller
public class MessageController {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private MessageService messageService;
	

	@Autowired
	private NoticeService noticeService;
	
	
	
	
	

	/**
	 * 企业页面的消息
	 * @return
	 */
	@RequestMapping(value = "company_message1.html", method = RequestMethod.GET)
	public ModelAndView companyMessage1() {
		ModelAndView mav = new ModelAndView("front_company/company_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		int userType = 3;
		return mav = messageService.showMessage(mav, userId, userType);
	}
	
	/**
	 * 操作员页面的消息
	 * @return
	 */
	@RequestMapping(value = "operate_message1.html", method = RequestMethod.GET)
	public ModelAndView operateMessage1() {
		ModelAndView mav = new ModelAndView("operate/operate_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		int userType = 4;
		return messageService.showMessage(mav, userId, userType);
	}
	
	/**
	 * 材料商页面的消息
	 * @return
	 */
	@RequestMapping(value = "material/message1.html", method = RequestMethod.GET)
	public ModelAndView materialMessage1() {
		ModelAndView mav = new ModelAndView("front_material/material_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		int userType = 1;
		return messageService.showMessage(mav, userId, userType);
	}
	
	/**
	 * 设备商页面的消息
	 * @return
	 */
	@RequestMapping(value = "equipment/message1.html", method = RequestMethod.GET)
	public ModelAndView equipmentMessage1(String isRead) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		int userType = 2;
		return messageService.showMessage(mav, userId, userType);
	}
	
	/**
	 * 个人或班组长的消息
	 * @return
	 */
	@RequestMapping(value = "user_message1.html", method = RequestMethod.GET)
	public ModelAndView userMessage1(String isRead) {
		ModelAndView mav = new ModelAndView("front_person/pt_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		int userType = 0;
		return messageService.showMessage(mav, userId, userType);
	}
	

	
	
	///////////////////////////////////////////////////////////////////////////////////////
	//后台消息系统
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * 显示公告列表
	 */
	@RequestMapping(value="notice_list",method=RequestMethod.GET)
	public ModelAndView Noticelist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/message_system/notice_list");
		if(dataCount == 0){
			dataCount = noticeService.countAllNotice(null);
		}
		mav.addObject("notlist", noticeService.getNoticeList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="notice_list2",method=RequestMethod.POST)
	public ModelAndView noticelist2(){
		return toList();
	}
	
	
	private ModelAndView toList(){
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = startDate.replace("-", "");
		String endDate1 = endDate.replace("-", "");
		ModelAndView mav = new ModelAndView("/message_system/notice_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		ModelUtils.queryDate(startDate1, endDate1, queryObj);
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = noticeService.countAllNotice(queryObj);
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("notlist", noticeService.getNoticeList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		
		return mav;
	}
	
	
	/**
	 * 发布公告
	 */
	@RequestMapping(value="notice_add",method=RequestMethod.GET)
	public String noticeAdd(){
		return "/message_system/notice_add";
	}
	
	
	@RequestMapping(value="notice_add2",method=RequestMethod.POST)
	public ModelAndView noticeAdd2(){
		String noticeTitle =request.getParameter("noticeTitle");
		String noticeInfo =request.getParameter("content");
		String beginTime = request.getParameter("beginTime");
		String endTime =request.getParameter("endTime");
		NoticeModel model = new NoticeModel();
		model.setNoticeTitle(noticeTitle);
		model.setNoticeInfo(noticeInfo);
		model.setBeginTime(DateStringUtils.parse(beginTime));
		model.setEndTime(DateStringUtils.parse(endTime));
		model.setCreateTime(new Date());
		boolean bln = noticeService.addNotice(model);
		ModelAndView mav = new ModelAndView("/message_system/notice_list");
		long dataCount = noticeService.countAllNotice(null);
		mav.addObject("notlist", noticeService.getNoticeList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	/**
	 * 显示消息列表
	 */
	@RequestMapping(value="message_list",method=RequestMethod.GET)
	public ModelAndView messagelist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/message_system/message_list");
		if(dataCount == 0){
			dataCount = messageService.countAllMessage(null);
		}
		mav.addObject("messlist", messageService.getMessageList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="message_list2",method=RequestMethod.POST)
	public ModelAndView messagelist2(){
		return toMessageList();
	}
	
	
	private ModelAndView toMessageList(){
		String receiveUserType = request.getParameter("receiveUserType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = startDate.replace("-", "");
		String endDate1 = endDate.replace("-", "");
		ModelAndView mav = new ModelAndView("/message_system/message_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(receiveUserType)){
			queryObj.put("receiveUserType", receiveUserType);
		}
		ModelUtils.queryDate(startDate1, endDate1, queryObj);
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = messageService.countAllMessage(queryObj);
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("messlist", messageService.getMessageList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		
		return mav;
	}
	
	
	/**
	 * 发布消息
	 */
	@RequestMapping(value="message_add",method=RequestMethod.GET)
	public String messageAdd(){
		return "/message_system/message_add";
	}
	
	
	@RequestMapping(value="message_add2",method=RequestMethod.POST)
	public ModelAndView messageAdd2(){
		String messageTitle =request.getParameter("messageTitle");
		String messageInfo =request.getParameter("content");
		String receiveUserId =request.getParameter("receiveUserId");
		String receiveUserType =request.getParameter("receiveUserType");
		MessageModel model = new MessageModel();
		model.setReceiveUserType(receiveUserType);
		model.setReceiveUserId(receiveUserId);
		model.setIsRead("0");
		model.setIsAdmin("0");
		model.setMessageTitle(messageTitle);
		model.setMessageInfo(messageInfo);
		model.setCreateTime(new Date());
		boolean bln = messageService.addMessage(model);
		ModelAndView mav = new ModelAndView("/message_system/message_list");
		long dataCount = messageService.countAllMessage(null);
		mav.addObject("messlist", messageService.getMessageList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
}
