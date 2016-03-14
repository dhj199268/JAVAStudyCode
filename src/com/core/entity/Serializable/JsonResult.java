package com.core.entity.Serializable;

import java.io.Serializable;

public class JsonResult implements Serializable {
	
	private static final long serialVersionUID = -1848492782788644570L;
	
	private int resultCode = 0;
	/**
	 * 操作结果信息
	 */
	private String resultMessage = "获取数据成功";
	/**
	 * 分页信息
	 */
	private Object pageInfo;
	/**
	 * 返回的数据
	 */
	private Object data;

	public void setData(Object data) {
		this.data = data;
	}

	public int getResultCode() {
		return resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public Object getPageInfo() {
		return pageInfo;
	}

	public Object getData() {
		return data;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public void setPageInfo(Object pageInfo) {
		this.pageInfo = pageInfo;
	}


}
