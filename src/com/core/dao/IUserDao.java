package com.core.dao;

import com.core.entity.struct.SysUser;
import com.core.entity.struct.SysUserEx;

public interface IUserDao {
	
	/**
	 * ���������ȡϵͳ����Ա��Ϣ
	 * @user coding�� 2014��6��24��
	 */
	public SysUser getSysUserByEmail(String userEmail) throws Exception;
	public SysUserEx getSysUserByUserName(String userName) throws Exception;
	public boolean updateSysUser(SysUser user) throws Exception;

}
