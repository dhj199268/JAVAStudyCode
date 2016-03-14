package com.core.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.entity.struct.SysUserEx;

public interface IUserService {
	/**
	 * 系统管理员登录
	 * 
	 * @user coding云 2014年6月24日
	 */
	public SysUserEx sysAdminLogin(SysUserEx user, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
