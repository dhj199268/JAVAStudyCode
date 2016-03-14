package com.core.entity.Serializable;

import java.io.Serializable;
import java.util.Date;

public class ValidCode implements Serializable {

	private static final long serialVersionUID = 7864664144841564681L;

	// ��֤���ʾ��
	private String codeKey;

	// ��֤��
	private String code;

	// ����ʱ�䣬���������ʶ������ɾ��һЩ���ڵ�����
	private Date createTime = new Date();

	public String getCodeKey() {
		return codeKey;
	}

	public String getCode() {
		return code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ValidCode() {
		super();
	}


	public ValidCode(String codeKey, String code) {
		super();
		this.codeKey = codeKey;
		this.code = code;
	}
}
