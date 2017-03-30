package com.fengyun.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录权限过滤器
 * @author zheng
 * 如果过滤检查已经登陆就放过继续请求，否则直接跳回首页
 */
public class LoginOverdueFilter implements Filter {

	private static final String LOGIN_URL="/toLogin.html";
	private static final String ADMIN_URL="/toLogin.html";
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("前台登录权限过滤器创建了！");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤请求...");
		
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse response =  (HttpServletResponse)resp;
		//session中获取用户名信息  
		Object userId = request.getSession().getAttribute("userId");  
		Object admin = request.getSession().getAttribute("admin");  
		//普通用户登录过滤
        if (userId==null||"".equals(userId.toString())) { 
        	//超级管理员过滤
        	if(admin==null||"".equals(admin.toString())){
         	   response.sendRedirect(request.getContextPath()+ADMIN_URL);
         	   return ;
            }
        	//如果普通用户和超级管理员都没有登陆内容，说明登录过期
        	System.out.println("登录过期，请重新登录！");
            response.sendRedirect(request.getContextPath()+LOGIN_URL);
            PrintWriter printWriter = response.getWriter();
            String relogin = "登录过期，请重新登录！";
            printWriter.write(relogin);
            printWriter.flush();
            printWriter.close();
            return ;
        }
        //过滤通过，放行
        chain.doFilter(request, response);
		System.out.println("过滤响应！");
	}

	@Override
	public void destroy() {
		System.out.println("登录权限过滤器销毁了！");
		
	}

}
