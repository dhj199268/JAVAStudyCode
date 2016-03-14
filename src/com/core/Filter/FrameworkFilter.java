package com.core.Filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrameworkFilter implements Filter {
	private final Logger logger = Logger.getLogger(this.getClass());
	private FilterConfig config;
	private static final String baseUrlStatic = "baseUrlStatic";
	/**
	 * 定义登录页面
	 */
	public static final String LOGIN_PAGE = "/jsp/system/login.jsp";
	public static String[] EXCEPT_PAGE;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("Filter handler STEP3: Destroy Filter  destroy function");
		this.config = null;

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		logger.info("Filter handler STEP2:Do Filter  doFilter function");
		logger.info("do filter request url:" + request.getRequestURI());
		
		request.setAttribute(baseUrlStatic, config.getInitParameter(baseUrlStatic)); // 所有jsp页面引用的js、css均从这里提供根路径，页面只需以jstl取值即可"${baseUrlStatic}"
		request.setAttribute("version", new Random().nextInt());

		/*for (String exception : EXCEPT_PAGE) {
			if (request.getRequestURI().endsWith(exception)) {
				filterChain.doFilter(request, response);
				return;
			}
		}*/
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("Filter handler STEP1: Filter init fuction Get config");
		String exception = filterConfig.getInitParameter("exception");
		if (exception != null && !"".equals(exception)) {
			EXCEPT_PAGE = exception.split(",");
		}
		this.config = filterConfig;
	}

}
