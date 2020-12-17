package com.src.entity;

import java.io.Serializable;

public class PayoutVerifyAccountResponse implements Serializable {

	private static final long serialVersionUID = 549280136379712518L;
	
	private boolean status;
	private String msg;
	private String code;
	
	PayoutVerifyAccountResponseData data;


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public PayoutVerifyAccountResponseData getData() {
		return data;
	}


	public void setData(PayoutVerifyAccountResponseData data) {
		this.data = data;
	}
		
}
