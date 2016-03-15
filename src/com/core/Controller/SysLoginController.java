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
		logger.info("系统管理员登录");
		return "system/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		logger.info("系统管理员退出登录");
		request.getSession().invalidate();
		return "system/login";
	}
	
	/**
	 * 系统管理员登录接口
	 * @user coding云
	 * 2014-9-20
	 */
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	@ResponseBody 
	public String loginCheck( @RequestBody SysUserEx user, HttpServletRequest request, HttpServletResponse response){
		logger.info("sys admin login info:" + user.toString());
		boolean flag = false;
		String errorMessage = "用户登录失败";
		JsonResult jsonResult = new JsonResult();
		try {
			user = userService.sysAdminLogin(user, request, response);
			flag = true;
		}catch (Exception serviceE){
			logger.error("sys admin login failed!", serviceE);
			errorMessage = serviceE.getMessage();
		}
		
		jsonResult.setResultCode(flag ? 0 : 1);
		jsonResult.setResultMessage(flag ? "用户登录成功" : errorMessage);
		jsonResult.setData(user);
		return new Gson().toJson(jsonResult);
	}
	
}
