package com.fengyun.web.cache.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.service.impl.CompanyServiceImpl;
import com.fengyun.web.service.impl.EquipmentServiceImpl;
import com.fengyun.web.service.impl.MaterialServiceImpl;
import com.fengyun.web.service.impl.ProjectServiceImpl;
import com.fengyun.web.service.impl.RequirementsServiceImpl;
import com.mongodb.BasicDBObject;

/**
 * 首页缓存
 * 
 */
public class IndexPage {
	private static Log log = LogFactory.getLog(IndexPage.class);

	private final static int PAGE_SIZE = 4;//

	private List<CompanyModel> companys = new ArrayList<CompanyModel>();//公司
	private List<ProjectModel> projects = new ArrayList<ProjectModel>();//项目

	private List<RequirementsModel> t2ulist = new ArrayList<RequirementsModel>();// 班组招聘
	private List<RequirementsModel> p2tlist = new ArrayList<RequirementsModel>();// 项目招聘施工班组
	private List<RequirementsModel> u2tlist = new ArrayList<RequirementsModel>();// 个人求职
	private List<RequirementsModel> t2plist = new ArrayList<RequirementsModel>();// 班组求职
	private List<RequirementsModel> p2mlist = new ArrayList<RequirementsModel>();// 材料采购
	private List<RequirementsModel> p2elist = new ArrayList<RequirementsModel>();// 设备租赁
	private List<RequirementsModel> m2plist = new ArrayList<RequirementsModel>();// 材料供应
	private List<RequirementsModel> e2plist = new ArrayList<RequirementsModel>();// 设备供应

	public void reload() {
		log.info("开始刷新首页了~");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 2);// 前台只能查看已审核过的公司信息
		// 公司信息
		companys = new CompanyServiceImpl().getCompanyList(queryObj, 1,PAGE_SIZE);
		 //项目信息
		 queryObj.clear();
		 queryObj.put("check", 1);
		 projects = new ProjectServiceImpl().getProjectList(queryObj,1,PAGE_SIZE);
		 //班组招聘
		 queryObj.clear();
		 queryObj.put("status", 1);
		 queryObj.put("type", 2);
		 queryObj.put("userType", 2);
		 queryObj.put("teamType", 1);
		t2ulist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //项目招聘施工班组
		 queryObj.clear();
		 queryObj.put("teamType", 1);
		 queryObj.put("status", 1);
		 queryObj.put("type", 2);
		 queryObj.put("userType", 3);
		 p2tlist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //个人求职
		 queryObj.clear();
		 queryObj.put("status", 1);
		 queryObj.put("type", 1);
		 queryObj.put("userType", 1);
		 u2tlist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //班组求职
		 queryObj.put("status", 1);
		 queryObj.put("type", 1);
		 queryObj.put("userType", 2);
		 queryObj.put("teamType", 1);
		 t2plist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //材料采购
		 queryObj.clear();
		 queryObj.put("teamType", 2);
		 queryObj.put("status", 1);
		 queryObj.put("type", 2);
		 queryObj.put("userType", 3);
		 p2mlist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //设备租赁
		 queryObj.clear();
		 queryObj.put("teamType", 3);
		 queryObj.put("status", 1);
		 queryObj.put("type", 2);
		 queryObj.put("userType", 3);
		 p2elist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 //材料供应
		 queryObj.clear();
		 queryObj.put("status", 1);
		 queryObj.put("type", 1);
		 queryObj.put("userType", 2);
		 queryObj.put("teamType", 2);
		 m2plist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		if(m2plist != null && !m2plist.isEmpty()){
			for(RequirementsModel model:m2plist){
				MaterialModel materialModel = new MaterialServiceImpl().getById(model.getrId());
				if(materialModel != null)
					model.setMaterialModel(materialModel);
			}
		}
		//设备供应
		 queryObj.clear();
		 queryObj.put("status", 1);
		 queryObj.put("type", 1);
		 queryObj.put("userType", 2);
		 queryObj.put("teamType", 3);
		 e2plist = new RequirementsServiceImpl().getList(queryObj,1,PAGE_SIZE);
		 if(e2plist != null && !e2plist.isEmpty()){
				for(RequirementsModel model:e2plist){
					EquipmentModel equipmentModel = new EquipmentServiceImpl().getById(model.getrId());
					if(equipmentModel != null)
						model.setEquipmentModel(equipmentModel);
				}
			}
	}

	public List<CompanyModel> getCompanys() {
		return companys;
	}

	public List<ProjectModel> getProjects() {
		return projects;
	}

	public List<RequirementsModel> getT2ulist() {
		return t2ulist;
	}

	public List<RequirementsModel> getP2tlist() {
		return p2tlist;
	}

	public List<RequirementsModel> getU2tlist() {
		return u2tlist;
	}

	public List<RequirementsModel> getT2plist() {
		return t2plist;
	}

	public List<RequirementsModel> getP2mlist() {
		return p2mlist;
	}

	public List<RequirementsModel> getP2elist() {
		return p2elist;
	}

	public List<RequirementsModel> getM2plist() {
		return m2plist;
	}

	public List<RequirementsModel> getE2plist() {
		return e2plist;
	}

}
