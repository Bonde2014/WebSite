package cn.com.bonde.b2b.website.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bonde.b2b.website.util.Constants;

/**
 * @author situbin
 * 
 */
public class SessionTimeoutFilter implements Filter
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String url = request.getRequestURL().toString();
		response.addHeader("X-UA-Compatible", "IE=EmulateIE8");
		// 将过期日期设置为一个过去时间
		response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
		// 设置 HTTP/1.1 no-cache 头
		response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		// 设置标准 HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		Object userInfo = session.getAttribute(Constants.SESSION_LOGIN);

		// --------end------------
		if (userInfo == null)
		{
			if (url.endsWith("goShopcart.do") )
			{
				servletResponse.getWriter().write("<script type=\"text/javascript\">window.location='"+request.getContextPath()+"/pages/login.jsp';</script>");
			}
			else
			{
				filterChain.doFilter(servletRequest, servletResponse);
			}
		}
		else
		{
			filterChain.doFilter(servletRequest, servletResponse);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException
	{

	}

}
