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
import com.fengyun.web.db.playermodel.BidInfoModel;
import com.fengyun.web.service.BidInfoService;
import com.mongodb.BasicDBObject;

@Controller
public class BidInfoController {
	
	@Autowired
	private BidInfoService bidInfoService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 显示招标信息列表
	 * @param pageNow
	 * @param dataCount
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="bidInfo_list",method=RequestMethod.GET)
	public ModelAndView BidInfolist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_list");
		if(dataCount == 0){
			dataCount = bidInfoService.countAllBidInfo(null);
		}
		mav.addObject("blist", bidInfoService.getBidInfoList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="bidInfo_list2",method=RequestMethod.POST)
	public ModelAndView bidInfolist2(){
		return toList();
	}
	
	
	private ModelAndView toList(){
		String title = request.getParameter("title");
		String bidtype = request.getParameter("bidtype");
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(title)){
			queryObj.put("title", title);
		}
		if(StringUtils.isNotBlank(bidtype)){
			queryObj.put("bidtype", Integer.parseInt(bidtype));
		}
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = bidInfoService.countAllBidInfo(queryObj);
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
		
		mav.addObject("blist", bidInfoService.getBidInfoList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("title", title);
		mav.addObject("bidtype", Integer.parseInt(bidtype));
		return mav;
	}
	
	
	/**
	 * 新增招标信息
	 */
	@RequestMapping(value="bidInfo_add",method=RequestMethod.GET)
	public String bidInfoAdd(){
		return "/bidInfo/bidInfo_add";
	}
	
	
	@RequestMapping(value="bidInfo_add2",method=RequestMethod.POST)
	public ModelAndView bidInfoAdd2(){
		String title =request.getParameter("title");
		String URL = request.getParameter("URL");
		int bidtype = Integer.parseInt(request.getParameter("bidtype"));
		boolean bln = bidInfoService.addBidInfo(title,URL,bidtype);
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_list");
		long dataCount = bidInfoService.countAllBidInfo(null);
		mav.addObject("blist", bidInfoService.getBidInfoList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	/**
	 * 修改招标信息
	 */
	@RequestMapping(value="bidInfo_modify",method=RequestMethod.GET)
	public ModelAndView bidInfoModify(String id){
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_modify");
		BidInfoModel model = bidInfoService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="bidInfo_modify2",method=RequestMethod.POST)
	public ModelAndView bidInfoModify2(){
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String URL = request.getParameter("URL");
		int bidtype = Integer.parseInt(request.getParameter("bidtype"));
		
		BidInfoModel model = bidInfoService.getById(id);
		if(model != null){
			model.setTitle(title);
			model.setURL(URL);
			model.setBidtype(bidtype);
			model.setCreateTime(new Date());
			bidInfoService.updateBidInfo(model);
		}
		
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_list");
		long dataCount = bidInfoService.countAllBidInfo(null);
		mav.addObject("blist", bidInfoService.getBidInfoList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	
	/**
	 * 删除招标信息
	 * @return
	 */
	@RequestMapping(value="bidInfo_del",method=RequestMethod.GET)
	public ModelAndView bidInfoDel(String id){
		bidInfoService.delBidInfo(id);
		ModelAndView mav = new ModelAndView("/bidInfo/bidInfo_list");
		long dataCount = bidInfoService.countAllBidInfo(null);
		mav.addObject("blist", bidInfoService.getBidInfoList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

}
