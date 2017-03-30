package com.fengyun.web.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TomcatListener implements ServletContextListener{  
	  
    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {
    	//清理在线玩家
    	
        System.out.println("tomcat关闭了..........");  
    }

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("tomcat启动..........");  
	}  

}  