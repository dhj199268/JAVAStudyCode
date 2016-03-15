package com.core.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	private final static Logger logger = Logger.getLogger(IndexController.class);

	/**
	 * 进入首页
	 * 
	 * @user codingyun.com 2014年9月4日
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// 对应的是WebContent目录下的WEB-INF目录下的jsp目录下的demo下的index.jsp
		// 请查看配置文件springMvc3-servlet.xml仔细体会一下
		logger.info("[hander]:IndexController " + "[fucntion]:index" + "[requst]:system/login"+"[reqpose]:'/'");
		return "system/login";
	}

}
