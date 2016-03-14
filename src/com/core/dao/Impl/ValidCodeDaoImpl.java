package com.core.dao.Impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.core.dao.IValidCodeDao;
import com.core.dao.Operation.IValidCodeDaoOperation;
import com.core.entity.Serializable.ValidCode;


@Repository
public class ValidCodeDaoImpl extends SqlSessionDaoSupport implements IValidCodeDao {

	@Autowired
//	@Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean saveValidCode(ValidCode validCode) {
		// TODO Auto-generated method stub
		int temp = this.getSqlSession().getMapper(IValidCodeDaoOperation.class).saveValidCode(validCode);
		if (temp > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ValidCode getValidCodeByCodeKey(String codeKey) {
		// TODO Auto-generated method stub
		if (codeKey == null) {
			return null;
		} else {
			return this.getSqlSession().getMapper(IValidCodeDaoOperation.class).getValidCodeByCodeKey(codeKey);
		}

	}

	@Override
	public boolean remove(ValidCode code) {
		// TODO Auto-generated method stub
		if (code == null) {
			return false;
		} else {

			int temp = this.getSqlSession().getMapper(IValidCodeDaoOperation.class).remove(code);

			if (temp > 0) {
				return true;
			} else {
				return false;
			}

		}
	}

}
