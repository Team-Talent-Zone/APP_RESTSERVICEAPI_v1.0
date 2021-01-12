package com.src.entity;

import java.io.Serializable;

/**
 * The <code> PayoutVerifyAccountRequest </code> class defines a POJO which is a
 * request data for payout verify account functionality.
 * 
 * @author azmiri
 * @version 1.0
 *
 */

public class PayoutVerifyAccountRequest implements Serializable {

	private static final long serialVersionUID = 5315065184092039811L;

	private String accountnumber;
	private String ifsccode;
	private int userid;

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
