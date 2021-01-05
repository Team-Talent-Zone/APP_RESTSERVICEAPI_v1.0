package com.src.entity;

import java.io.Serializable;

/**
 * The <code> PayoutTransferRequest </code> POJO class
 * provides a functionality for payout transfer request.
 * 
 * @author azmiri
 * @version 1.0
 *
 */

public class PayoutTransferRequest implements Serializable {

	private static final long serialVersionUID = 567883350595725107L;
	
	private String beneficiaryAccountNumber;
	private String beneficiaryIfscCode;
	private String beneficiaryName;
	private String beneficiaryEmail;
	private String beneficiaryMobile;
	private String purpose;
	private double amount;
	private String batchId;
	private String merchantRefId;
	private String paymentType;
	private boolean retry;
	
	
	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public String getBeneficiaryIfscCode() {
		return beneficiaryIfscCode;
	}
	public void setBeneficiaryIfscCode(String beneficiaryIfscCode) {
		this.beneficiaryIfscCode = beneficiaryIfscCode;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryEmail() {
		return beneficiaryEmail;
	}
	public void setBeneficiaryEmail(String beneficiaryEmail) {
		this.beneficiaryEmail = beneficiaryEmail;
	}
	public String getBeneficiaryMobile() {
		return beneficiaryMobile;
	}
	public void setBeneficiaryMobile(String beneficiaryMobile) {
		this.beneficiaryMobile = beneficiaryMobile;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isRetry() {
		return retry;
	}
	public void setRetry(boolean retry) {
		this.retry = retry;
	}
	
	

}
