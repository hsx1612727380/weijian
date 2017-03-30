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
import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.service.LawInsuService;
import com.mongodb.BasicDBObject;

@Controller
public class LawInsuController {
	@Autowired
	private LawInsuService lawInsuService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 显示法律保险列表
	 * @param pageNow
	 * @param dataCount
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="lawInsu_list",method=RequestMethod.GET)
	public ModelAndView LawInsulist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_list");
		if(dataCount == 0){
			dataCount = lawInsuService.countAllLawInsu(null);
		}
		mav.addObject("lalist", lawInsuService.getLawInsuList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="lawInsu_list2",method=RequestMethod.POST)
	public ModelAndView lawInsulist2(){
		return toList();
	}
	
	
	private ModelAndView toList(){
		String title = request.getParameter("title");
		String lawtype = request.getParameter("lawtype");
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(title)){
			queryObj.put("title", title);
		}
		if(StringUtils.isNotBlank(lawtype)){
			queryObj.put("lawtype", Integer.parseInt(lawtype));
		}
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = lawInsuService.countAllLawInsu(queryObj);
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
		
		mav.addObject("lalist", lawInsuService.getLawInsuList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("title", title);
		mav.addObject("lawtype", Integer.parseInt(lawtype));
		return mav;
	}
	
	
	/**
	 * 新增法律保险
	 */
	@RequestMapping(value="lawInsu_add",method=RequestMethod.GET)
	public String lawInsuAdd(){
		return "/lawInsu/lawInsu_add";
	}
	
	
	@RequestMapping(value="lawInsu_add2",method=RequestMethod.POST)
	public ModelAndView lawInsuAdd2(){
		String title =request.getParameter("title");
		String note =request.getParameter("content");
		int lawtype = Integer.parseInt(request.getParameter("lawtype"));
		boolean bln = lawInsuService.addLawInsu(title,lawtype,note);
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_list");
		long dataCount = lawInsuService.countAllLawInsu(null);
		mav.addObject("lalist", lawInsuService.getLawInsuList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	/**
	 * 修改法律保险
	 */
	@RequestMapping(value="lawInsu_modify",method=RequestMethod.GET)
	public ModelAndView lawInsuModify(String id){
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_modify");
		LawInsuModel model = lawInsuService.getById(id);
		if(model != null)
			mav.addObject("model", model);
			mav.addObject("content", model.getNote());
		return mav;
	}
	
	@RequestMapping(value="lawInsu_modify2",method=RequestMethod.POST)
	public ModelAndView lawInsuModify2(){
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		int lawtype = Integer.parseInt(request.getParameter("lawtype"));
		String note = request.getParameter("content");
		
		LawInsuModel model = lawInsuService.getById(id);
		if(model != null){
			model.setTitle(title);
			model.setLawtype(lawtype);
			model.setNote(note);
			model.setCreateTime(new Date());
			lawInsuService.updateLawInsu(model);
		}
		
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_list");
		long dataCount = lawInsuService.countAllLawInsu(null);
		mav.addObject("lalist", lawInsuService.getLawInsuList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	
	/**
	 * 删除法律保险
	 * @return
	 */
	@RequestMapping(value="lawInsu_del",method=RequestMethod.GET)
	public ModelAndView bidInfoDel(String id){
		lawInsuService.delLawInsu(id);
		ModelAndView mav = new ModelAndView("/lawInsu/lawInsu_list");
		long dataCount = lawInsuService.countAllLawInsu(null);
		mav.addObject("lalist", lawInsuService.getLawInsuList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	
	
	
	


}
