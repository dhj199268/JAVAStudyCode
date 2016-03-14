package com.core.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.Service.IValidCodeService;
import com.core.dao.IValidCodeDao;
import com.core.entity.Serializable.ValidCode;

@Service
public class ValidCodeServiceImpl implements IValidCodeService {
	@Autowired
	private IValidCodeDao validCodeDao;

	@Override
	public boolean checkValidCode(String random, String type, String input) {
		String codeKey = genCodeKey(type, random);
		ValidCode code = validCodeDao.getValidCodeByCodeKey(codeKey);
		if (code == null) {
			return false;
		}
		if (!code.getCode().equalsIgnoreCase(input)) {
			return false;
		}
		this.remove(code);
		return true;
	}

	@Override
	public void recordValidCode(String random, String type, String code) {
		String codeKey = this.genCodeKey(type, random);
		// create new code
		ValidCode validCode = new ValidCode(codeKey, code);
		validCodeDao.saveValidCode(validCode);
	}

	@Override
	public void remove(ValidCode code) {
		validCodeDao.remove(code);
	}

	private String genCodeKey(String type, String random) {
		return type + "." + random;
	}
}
