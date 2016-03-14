package com.core.Service;

import com.core.entity.Serializable.ValidCode;

public interface IValidCodeService {
public void recordValidCode(String random, String type, String code);
	
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
	public boolean checkValidCode(String randomString, String type, String authCode);
	
	public void remove(ValidCode code);
}
