package com.core.dao.Impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.core.dao.IUserDao;
import com.core.dao.Operation.IUserDaoOperation;
import com.core.entity.struct.SysUser;
import com.core.entity.struct.SysUserEx;
import com.tool.util.StringUtil;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public SysUser getSysUserByEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(userEmail)) {
			return null;
		} else {
			return this.getSqlSession().getMapper(IUserDaoOperation.class).getSysUserByEmail(userEmail);
		}
	}

	@Override
	public SysUserEx getSysUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(userName)) {
			return null;
		} else {
			return this.getSqlSession().getMapper(IUserDaoOperation.class).getSysUserByUserName(userName);
		}
	}

	@Override
	public boolean updateSysUser(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		if (user == null) {
			return false;
		} else {
			try {
				
				int temp = this.getSqlSession().getMapper(IUserDaoOperation.class).updateSysUser(user);
				if (temp > 0) {
					return true;
				} else {
					return false;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
}
