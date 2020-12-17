package com.src.entity;

import java.io.Serializable;

public class PayoutVerifyAccountResponseData implements Serializable {

	private static final long serialVersionUID = 8480275827741452611L;
	
	private String accountExists;
	private String beneficiaryName;
	private String status;
	private String error;
	
	public String getAccountExists() {
		return accountExists;
	}
	public void setAccountExists(String accountExists) {
		this.accountExists = accountExists;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	


}
