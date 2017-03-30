package com.fengyun.web.filter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session统计
 * @author Administrator
 *
 */
public class SessionCounter implements HttpSessionListener {   

	private static int activeSessions = 0;   
	
	public void sessionCreated(HttpSessionEvent se) {   
		activeSessions++; 
		System.out.println("++++++++玩家上线了++++++++");
	}   
	
	public void sessionDestroyed(HttpSessionEvent se) {  
		if(activeSessions > 0)   
			activeSessions--;
		String sessionId = se.getSession().getId();
		
	}   
	
	public static int getActiveSessions() {   
		return activeSessions;   
	}   
}   


