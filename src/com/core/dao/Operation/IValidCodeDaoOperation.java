package com.core.dao.Operation;

import com.core.entity.Serializable.ValidCode;

public interface IValidCodeDaoOperation {
	
	public int saveValidCode(ValidCode validCode);

	/**
	 * �����֤�����Ƿ���ȷ
	 * <p>
	 * ������֤�룬�ο���/valid/image?type=TYPE&random=RANDOM
	 * 
	 * @param random
	 *            ���ֵ����������֤���ʱ��һ��
	 * @param type
	 *            ��֤�����ͣ�������֤���ʱ��һ��
	 * @param input
	 *            ��ǰ�û�������
	 * @return
	 */
	public ValidCode getValidCodeByCodeKey(String codeKey);

	public int remove(ValidCode code);
}
