package com.core.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.entity.struct.SysUserEx;

public interface IUserService {
	/**
	 * ϵͳ����Ա��¼
	 * 
	 * @user coding�� 2014��6��24��
	 */
	public SysUserEx sysAdminLogin(SysUserEx user, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
