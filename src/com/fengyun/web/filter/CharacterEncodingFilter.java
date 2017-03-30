package com.fengyun.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符编码过滤
 * @author apaul
 *
 */
public class CharacterEncodingFilter implements Filter {
	String encodingString="UTF-8";  
	    @Override  
	    public void destroy() {  
	        encodingString="";  
	    }  
	  
	    @Override  
	    public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2)  
	                                    throws IOException, ServletException {  
	       if(encodingString!=null){  
	            //注意MyEclipse的版本不同，方法doFilter的参数有可能不同，  
	            //设置字符编码，认准其类型为ServletRequest即可  
	            // 我用的是MyEclipse10  
	            arg0.setCharacterEncoding(encodingString);   
	       }  
	       arg2.doFilter(arg0, arg1);  
   }  
	  
    @Override  
	   public void init(FilterConfig arg0) throws ServletException {  
        //注意MyEclipse的版本不同，方法init的参数有可能不同  
	       //这里的参数为arg0  
	        // 我用的是MyEclipse10  
	       //从配置文件中取编码  
        this.encodingString=arg0.getInitParameter("encoding").trim();  
	       if(encodingString==null){  
	             encodingString="UTF-8";  
	        }  
	  }  

}
