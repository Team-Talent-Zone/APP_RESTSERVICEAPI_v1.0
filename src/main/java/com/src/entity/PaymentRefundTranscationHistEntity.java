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

@Entity(name = "paymentsRefundTrans")
@Table(name = "APP_PAYMENTS_REFUND_TRANSACTION_HISTORY")
public class PaymentRefundTranscationHistEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer Id;

	@Column(name = "refundamount")
	private float refundamount;

	@Column(name = "createdon")
	private String createdon;

	@Column(name = "refundId")
	private String refundId;

	@Column(name = "refundstatus")
	private String refundstatus;

	@Column(name = "refundcompletedon")
	private String refundcompletedon;

	@Column(name = "refundcreatedon")
	private String refundcreatedon;

	@Column(name = "totalamount")
	private float totalamount;

	@Column(name = "errorCode")
	private String errorCode;

	@Column(name = "message")
	private String message;

	@Column(name = "refundrequestamount")
	private float refundrequestamount;

	@Column(insertable = false, updatable = false, name = "paymentId")
	private int paymentId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId", nullable = false)
	@JsonIgnore
	private PaymentEntity payments;

	@Column(insertable = false, updatable = false, name = "userId")
	private String userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public float getRefundamount() {
		return refundamount;
	}

	public void setRefundamount(float refundamount) {
		this.refundamount = refundamount;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getRefundstatus() {
		return refundstatus;
	}

	public void setRefundstatus(String refundstatus) {
		this.refundstatus = refundstatus;
	}

	public String getRefundcompletedon() {
		return refundcompletedon;
	}

	public void setRefundcompletedon(String refundcompletedon) {
		this.refundcompletedon = refundcompletedon;
	}

	public String getRefundcreatedon() {
		return refundcreatedon;
	}

	public void setRefundcreatedon(String refundcreatedon) {
		this.refundcreatedon = refundcreatedon;
	}

	public float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getRefundrequestamount() {
		return refundrequestamount;
	}

	public void setRefundrequestamount(float refundrequestamount) {
		this.refundrequestamount = refundrequestamount;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

}