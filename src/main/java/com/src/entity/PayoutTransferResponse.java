package com.src.entity;

import java.io.Serializable;

public class PayoutTransferResponse implements Serializable{

	private static final long serialVersionUID = -5255327750602996566L;
	
	private boolean status;
	private String msg;
	private String code;
	
	PayoutTransferResponseData data;

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

	public PayoutTransferResponseData getData() {
		return data;
	}

	public void setData(PayoutTransferResponseData data) {
		this.data = data;
	}
	
	

}
