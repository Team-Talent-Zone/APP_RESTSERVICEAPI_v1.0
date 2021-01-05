package com.src.entity;

import java.io.Serializable;


/**
 * The <code> BeneficiaryDetails </code> class defines 
 * the freelancer bank/payment details
 * to perform payout functionality.
 * 
 * @author Azmiri
 * @version 1.0
 *
 */
public class PayoutBeneficiaryDetails implements Serializable {

	private static final long serialVersionUID = -5095780759069974217L;

	private int beneficiaryId;
	private String name;
	private String email;
	private int mobile;
	private String accountNo;
	private String ifsc;
	private String vpa;
	private int merchantId;
	private String addedOn;
	private String updatedon;
	private String isVerified;
	private String nameWithBank;
	private String cardNo;

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public String getNameWithBank() {
		return nameWithBank;
	}

	public void setNameWithBank(String nameWithBank) {
		this.nameWithBank = nameWithBank;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
