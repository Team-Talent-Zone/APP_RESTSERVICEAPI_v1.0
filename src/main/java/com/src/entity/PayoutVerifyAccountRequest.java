package com.src.entity;

import java.io.Serializable;

public class PayoutVerifyAccountRequest implements Serializable {

	private static final long serialVersionUID = 5315065184092039811L;
	
	private String accountNumber;
	private String ifscCode;
	private String merchantRefId;
	private String amount;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getMerchantRefId() {
		return merchantRefId;
	}
	public void setMerchantRefId(String merchantRefId) {
		this.merchantRefId = merchantRefId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
}
