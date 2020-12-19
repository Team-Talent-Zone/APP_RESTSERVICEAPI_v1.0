package com.src.entity;

import java.io.Serializable;

public class PayoutTransferResponseData implements Serializable {

	private static final long serialVersionUID = -6415500862881607517L;
	
	private String batchId;
	private String merchantRefId;
	private String error;
	private int code[];
	
	
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getMerchantRefId() {
		return merchantRefId;
	}
	public void setMerchantRefId(String merchantRefId) {
		this.merchantRefId = merchantRefId;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int[] getCode() {
		return code;
	}
	public void setCode(int[] code) {
		this.code = code;
	}
	

}
