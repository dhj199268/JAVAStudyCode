package com.core.dao.Operation;

import com.core.entity.Serializable.ValidCode;

public interface IValidCodeDaoOperation {
	
	public int saveValidCode(ValidCode validCode);

	/**
	 * 检查验证输入是否正确
	 * <p>
	 * 请求验证码，参考：/valid/image?type=TYPE&random=RANDOM
	 * 
	 * @param random
	 *            随机值，与请求验证码的时候一致
	 * @param type
	 *            验证码类型，与请验证码的时候一致
	 * @param input
	 *            当前用户的输入
	 * @return
	 */
	public ValidCode getValidCodeByCodeKey(String codeKey);

	public int remove(ValidCode code);
}
