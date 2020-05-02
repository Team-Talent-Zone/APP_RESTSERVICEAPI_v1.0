package com.src.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The <code> PaymentEntity </code> class defines managed beans which provides
 * functionality on the <code>Payment Entity</code> Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "payments")
@Table(name = "APP_PAYMENTS")
public class PaymentEntity implements Serializable {
	private static final long serialVersionUID = 8210479559609264715L;

	@Id
	@Column(name = "paymentId")
	@GeneratedValue
	private Integer paymentId;

	@Column(name = "amount")
	private String amount;
	
	@Column(name = "key")
	private String key;

	@Column(name = "name")
	private String name;
	
	@Column(name = "createdon")
	private String createdon;

	@Column(name = "email")
	private String email;

	@Column(name = "furl")
	private String furl;

	@Column(name = "hash")
	private String hash;

	@Column(name = "phone")
	private String phone;

	@Column(name = "productinfo")
	private String productinfo;

	@Column(name = "service_provider")
	private String service_provider;

	@Column(name = "surl")
	private String surl;

	@Column(name = "txnid")
	private String txnid;

	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(insertable = true, updatable = false, name = "serviceId")
	private int serviceId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "payments")
	private PaymentFUTranscationHistEntity paymentsFUTrans;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "payments")
	private PaymentCBATranscationHistEntity paymentsCBATrans;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "payments")
	private PaymentRefundTranscationHistEntity paymentsRefundTrans;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "payments")
	private PaymentNotificationHistEntity paymentsNotifHistory;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String  getAmount() {
		return amount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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

	public String getService_provider() {
		return service_provider;
	}

	public void setService_provider(String service_provider) {
		this.service_provider = service_provider;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
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

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public PaymentFUTranscationHistEntity getPaymentsFUTrans() {
		return paymentsFUTrans;
	}

	public void setPaymentsFUTrans(PaymentFUTranscationHistEntity paymentsFUTrans) {
		this.paymentsFUTrans = paymentsFUTrans;
	}

	public PaymentCBATranscationHistEntity getPaymentsCBATrans() {
		return paymentsCBATrans;
	}

	public void setPaymentsCBATrans(PaymentCBATranscationHistEntity paymentsCBATrans) {
		this.paymentsCBATrans = paymentsCBATrans;
	}

	public PaymentRefundTranscationHistEntity getPaymentsRefundTrans() {
		return paymentsRefundTrans;
	}

	public void setPaymentsRefundTrans(PaymentRefundTranscationHistEntity paymentsRefundTrans) {
		this.paymentsRefundTrans = paymentsRefundTrans;
	}

	public PaymentNotificationHistEntity getPaymentsNotifHistory() {
		return paymentsNotifHistory;
	}

	public void setPaymentsNotifHistory(PaymentNotificationHistEntity paymentsNotifHistory) {
		this.paymentsNotifHistory = paymentsNotifHistory;
	}

}