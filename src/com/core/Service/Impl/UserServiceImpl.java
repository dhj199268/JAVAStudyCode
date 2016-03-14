package com.core.Service.Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.Service.IUserService;
import com.core.Service.IValidCodeService;
import com.core.dao.IUserDao;
import com.core.entity.struct.SysUserEx;
import com.tool.util.MD5Util;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IValidCodeService validCodeService;

	@Override
	public SysUserEx sysAdminLogin(SysUserEx user, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// TODO Auto-generated method stub
		if (!validCodeService.checkValidCode(user.getRandomString(), user.getType(), user.getAuthCode())) {
			throw new Exception("验证码错误！");
		}

		SysUserEx existUser = null;
		existUser = userDao.getSysUserByUserName(user.getUserName());

		if (existUser == null) {
			throw new Exception("用户不存在！");
		}

		if (!existUser.getUserPassword().equalsIgnoreCase(MD5Util.GetMD5Code(user.getUserPassword(), false))) {
			throw new Exception("用户密码错误！");
		}

		request.getSession().setAttribute("sysUser", existUser);

		return existUser;
	}

}
