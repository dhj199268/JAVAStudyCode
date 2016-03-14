package com.core.Interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.core.entity.struct.SysUser;

public class SysAdminInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger logger = Logger.getLogger(this.getClass());
	private static final Set<String> noMappingSet = new HashSet<String>();

	/**
	 * ¶¨ÒåµÇÂ¼Ò³Ãæ
	 */
	public static final String LOGIN_PAGE = "/system/login";

	static {
		noMappingSet.add("/system/login");
		noMappingSet.add("/system/login/loginCheck");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("interceptor excute order:1.preHandle================");
		logger.info("request url:" + request.getRequestURI());
		// TODO Auto-generated method stub
		if (noMappingSet.contains(request.getRequestURI())) {
			return true;
		}
		SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
		if (sysUser == null) {
			// request.getRequestDispatcher(LOGIN_PAGE).forward(request,
			// response);
			// response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
			response.sendRedirect("/system/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("interceptor excute order:2.postHandle================");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("interceptor excute order:3.afterCompletion================");
	}
}
