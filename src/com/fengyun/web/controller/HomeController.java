package com.fengyun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.SysData;

/***
 * 
 *
 */
@Controller 
public class HomeController {
	
	/***
	 * 首页 返回至/page/home.jsp页面
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		////创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面 
		ModelAndView mav = new ModelAndView("index");
		//缓存首页数据
		mav.addObject("companys",SysData.getIndexPage().getCompanys());//公司
		mav.addObject("projects",SysData.getIndexPage().getProjects());//项目
		mav.addObject("t2ulist",SysData.getIndexPage().getT2ulist());// 班组招聘
		mav.addObject("p2tlist",SysData.getIndexPage().getP2tlist());// 项目招聘施工班组
		mav.addObject("u2tlist",SysData.getIndexPage().getU2tlist());// 个人求职
		mav.addObject("t2plist",SysData.getIndexPage().getT2plist());// 班组求职
		mav.addObject("p2mlist",SysData.getIndexPage().getP2mlist());// 材料采购
		mav.addObject("p2elist",SysData.getIndexPage().getP2elist());// 设备租赁
		mav.addObject("m2plist",SysData.getIndexPage().getM2plist());// 材料供应
		mav.addObject("e2plist",SysData.getIndexPage().getE2plist());// 设备供应
		
		return mav;
	}
	
	@RequestMapping("404")
	public String error404(){
		return "404";
	}
	
	/**
	 * 个人注册
	 * @return
	 */
	@RequestMapping("reg")
	public String reg(){
		return "reg";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("protocol")
	public String protocol(){
		return "protocol";
	}
}
