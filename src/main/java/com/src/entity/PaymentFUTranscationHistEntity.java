package com.src.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The <code> PaymentFUTranscationHistEntity </code> class defines managed beans
 * which provides functionality on the
 * <code>Payment FU Transaction History Entity</code> Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "paymentsFUTrans")
@Table(name = "APP_PAYMENTS_FU_TRANSACTION_HISTORY")
public class PaymentFUTranscationHistEntity implements Serializable {
	private static final long serialVersionUID = 4762948170944908034L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer Id;

	@Column(insertable = false, updatable = false, name = "paymentId")
	private int paymentId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId", nullable = false)
	@JsonIgnore
	private PaymentEntity payments;

	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(insertable = true, updatable = false, name = "freelanceId")
	private int freelanceId;

	@Column(name = "createdon")
	private String createdon;

	@Column(name = "txnid")
	private String txnid;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private float amount;

	@Column(name = "hash")
	private String hash;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "payuMoneyId")
	private String payuMoneyId;

	@Column(name = "mode")
	private String mode;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public PaymentEntity getPayments() {
		return payments;
	}

	public void setPayments(PaymentEntity payments) {
		this.payments = payments;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public int getFreelanceId() {
		return freelanceId;
	}

	public void setFreelanceId(int freelanceId) {
		this.freelanceId = freelanceId;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPayuMoneyId() {
		return payuMoneyId;
	}

	public void setPayuMoneyId(String payuMoneyId) {
		this.payuMoneyId = payuMoneyId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}