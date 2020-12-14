package com.src.entity;

import java.io.Serializable;

/**
 * The <code> CreatePayOutBeneficiary </code> class defines a POJO for
 * creating benificary details for pay out functionality.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
public class CreatePayOutBeneficiary implements Serializable {

	private static final long serialVersionUID = -44196351047811690L;
	private String accountno;
	private String ifsc;
	private String vpa;
	private String name;
	private String email;
	private String mobile;
	private String status;
	private String msg;
	private String code;

	PayoutBeneficiaryDetails data;

	public PayoutBeneficiaryDetails getData() {
		return data;
	}

	public void setData(PayoutBeneficiaryDetails data) {
		this.data = data;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

}
