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
 * @author wq
 *
 */
public class BackgroundLoginOverdueFilter implements Filter {

	
	private static final String ADMIN_URL="/toBackgroundLogin.html";
	
	@Override
	public void destroy() {
		System.out.println("登录权限过滤器销毁了！");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤请求！");
		
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse response =  (HttpServletResponse)resp;
		//session中获取用户名信息  
		Object accountName = request.getSession().getAttribute("accountName");  
		//普通用户登录过滤
        if (accountName==null||"".equals(accountName.toString())) { 
        	System.out.println("登录过期，请重新登录！");
        	//超级管理员过滤
         	   	response.sendRedirect(request.getContextPath()+ADMIN_URL);
	        	//如果普通用户和超级管理员都没有登陆内容，说明登录过期
	        	System.out.println("登录过期，请重新登录！");
	            PrintWriter printWriter = response.getWriter();
	            String relogin = "登录过期，请重新登录！";
	            printWriter.write(relogin);
	            printWriter.flush();
	            printWriter.close();
	            return ;
        	
        	
        }
        chain.doFilter(request, response);
		
		System.out.println("过滤响应！");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("后台登录权限过滤器创建了！");

	}

}
