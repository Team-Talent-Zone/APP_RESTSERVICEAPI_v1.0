package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> FreeLanceOnServiceExpirationDetailsView </code> class defines
 * managed beans which provides functionality on the
 * <code>FreeLance On Service Expiration Details View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_PAYMENTS_HISTORY_FU")
public class PaymentHistoryFUView {

	@Id
	@Column(name = "paymentId") 
	private int paymentId;
	
	@Column(name = "userId") 
	private int userId;

	@Column(name = "amount") 
	private String amount;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "avtarurl")
	private String avtarurl;

	@Column(name = "name")
	private String name;

	@Column(name = "createdon")
	private String createdon;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String phone;

	@Column(name = "productinfo")
	private String productinfo;

	@Column(name = "txnid")
	private String txnid;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "status")
	private String status;

	
	

	public int getPaymentId() {
		return paymentId;
	}




	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getFullname() {
		return fullname;
	}




	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	public String getAvtarurl() {
		return avtarurl;
	}




	public void setAvtarurl(String avtarurl) {
		this.avtarurl = avtarurl;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCreatedon() {
		return createdon;
	}




	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getProductinfo() {
		return productinfo;
	}




	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}




	public String getTxnid() {
		return txnid;
	}




	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}




	public String getMode() {
		return mode;
	}




	public void setMode(String mode) {
		this.mode = mode;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getPayuMoneyId() {
		return payuMoneyId;
	}




	public void setPayuMoneyId(String payuMoneyId) {
		this.payuMoneyId = payuMoneyId;
	}




	@Column(name = "payuMoneyId")
	private String payuMoneyId;
}
