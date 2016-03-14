package com.core.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/system/article")
public class SysArticleController {
	private static Logger logger = Logger.getLogger(SysArticleController.class);

	/**
	 * ϵͳ����Ա ��������
	 * 
	 * @user jack 2014��8��7��
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getArticleList(HttpServletRequest request) throws Exception {
		logger.info("ϵͳ����Ա��������");
		return "system/blogArticleList";
	}
}
