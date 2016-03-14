package com.core.dao;

import com.core.entity.Serializable.ValidCode;

public interface IValidCodeDao {
	
	
public boolean saveValidCode(ValidCode validCode);
	
	/**
	 * �����֤�����Ƿ���ȷ
	 * <p>
	 * ������֤�룬�ο���/valid/image?type=TYPE&random=RANDOM
	 * 
	 * @param random ���ֵ����������֤���ʱ��һ��
	 * @param type ��֤�����ͣ�������֤���ʱ��һ��
	 * @param input ��ǰ�û�������
	 * @return
	 */
	public ValidCode getValidCodeByCodeKey(String codeKey);
	
	public boolean remove(ValidCode code);
}
