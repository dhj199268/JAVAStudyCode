package com.core.dao;

import com.core.entity.struct.SysUser;
import com.core.entity.struct.SysUserEx;

public interface IUserDao {
	
	/**
	 * 根据邮箱获取系统管理员信息
	 * @user coding云 2014年6月24日
	 */
	public SysUser getSysUserByEmail(String userEmail) throws Exception;
	public SysUserEx getSysUserByUserName(String userName) throws Exception;
	public boolean updateSysUser(SysUser user) throws Exception;

}
