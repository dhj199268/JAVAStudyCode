package com.core.entity.struct;

public class SysUserEx extends SysUser {
	
	private String authCode = "";

	private String randomString = "";

	private String type = "";

	public String getAuthCode() {
		return authCode;
	}

	public String getRandomString() {
		return randomString;
	}

	public String getType() {
		return type;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
