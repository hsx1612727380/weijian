package com.fengyun.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * 权限过滤器
 * @author user
 *
 */
public class PermissionFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610072141164564442L;
	
	private FilterConfig filterConfig;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//		try {
//			HttpServletRequest req = (HttpServletRequest) request;
//			WebUserInfo user = new WebUserInfoService().chklogin(req);
//			boolean hasPriv = false;
//			String url = req.getRequestURL().toString();
//			if (user != null) {
//				String popedom = user.getPopedom();
//				if (StringUtils.isNotBlank(popedom)) {// 非管理权限
//					if (popedom.equals("0"))
//						hasPriv = true;
//					else {
//						String[] strs = url.split("\\/");
//						if (strs.length > 4) {
//							if ("main".equals(strs[3]) || "user".equals(strs[3]))
//								hasPriv = true;
//							else {
//								String[] pops = popedom.split(",");
//								for (String pop : pops) {
//									if (StringUtils.isBlank(pop) || pop.length() < 1)
//										continue;
//									if (pop.equals("0")) {
//										hasPriv = true;
//										break;
//									} else {
//										pop = pop.substring(0, 1);
//										int ipop = Integer.parseInt(pop);
//										switch (ipop) {
//										case 1:
//											hasPriv = "admin".equals(strs[3]);
//											break;
//										case 2:
//											hasPriv = "gm".equals(strs[3]);
//											break;
//										case 3:
//											hasPriv = "playerdata".equals(strs[3]);
//											break;
//										case 4:
//											hasPriv = "datareport".equals(strs[3]);
//											break;
//										case 5:
//											hasPriv = "inner".equals(strs[3]);
//											break;
//										default:
//											break;
//										}
//										if (hasPriv) {
//											break;
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//			if (!hasPriv) {
//				url += req.getQueryString() == null ? "" : "?" + req.getQueryString();
//				url = java.net.URLEncoder.encode(url, "GBK");
//				((HttpServletResponse) response).sendRedirect("/index.do?url=" + url);
//				return;
//			}
//			filterChain.doFilter(request, response);
//		} catch (ServletException sx) {
//			filterConfig.getServletContext().log(sx.getMessage());
//		} catch (IOException iox) {
//			filterConfig.getServletContext().log(iox.getMessage());
//		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = filterConfig;
		
	}

}
