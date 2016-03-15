package com.core.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.Service.Impl.UserServiceImpl;
import com.core.entity.Serializable.JsonResult;
import com.core.entity.struct.SysUserEx;
import com.google.gson.Gson;

@Controller
@RequestMapping("/system/login")
public class SysLoginController{
	
	private final static Logger logger = Logger.getLogger(SysLoginController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(HttpServletRequest request){
		logger.info("ϵͳ����Ա��¼");
		return "system/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		logger.info("ϵͳ����Ա�˳���¼");
		request.getSession().invalidate();
		return "system/login";
	}
	
	/**
	 * ϵͳ����Ա��¼�ӿ�
	 * @user coding��
	 * 2014-9-20
	 */
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	@ResponseBody 
	public String loginCheck( @RequestBody SysUserEx user, HttpServletRequest request, HttpServletResponse response){
		logger.info("sys admin login info:" + user.toString());
		boolean flag = false;
		String errorMessage = "�û���¼ʧ��";
		JsonResult jsonResult = new JsonResult();
		try {
			user = userService.sysAdminLogin(user, request, response);
			flag = true;
		}catch (Exception serviceE){
			logger.error("sys admin login failed!", serviceE);
			errorMessage = serviceE.getMessage();
		}
		
		jsonResult.setResultCode(flag ? 0 : 1);
		jsonResult.setResultMessage(flag ? "�û���¼�ɹ�" : errorMessage);
		jsonResult.setData(user);
		return new Gson().toJson(jsonResult);
	}
	
}
