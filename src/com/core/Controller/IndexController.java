package com.core.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * ������ҳ
	 * 
	 * @user codingyun.com 2014��9��4��
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// ��Ӧ����WebContentĿ¼�µ�WEB-INFĿ¼�µ�jspĿ¼�µ�demo�µ�index.jsp
		// ��鿴�����ļ�springMvc3-servlet.xml��ϸ���һ��
		logger.info("[hander]:IndexController " + "[fucntion]:index" + "[requst]:system/login"+"[reqpose]:'/'");
		return "system/login";
	}

}
