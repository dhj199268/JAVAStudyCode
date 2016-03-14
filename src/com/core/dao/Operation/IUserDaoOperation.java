package com.core.dao.Operation;

import com.core.entity.struct.SysUser;
import com.core.entity.struct.SysUserEx;

public interface IUserDaoOperation {
	
	public SysUser getSysUserByEmail(String userEmail);
	public SysUserEx getSysUserByUserName(String userName);
	public int updateSysUser(SysUser user);

}
