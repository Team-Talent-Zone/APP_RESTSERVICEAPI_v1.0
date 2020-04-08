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
 * The <code> PaymentNotificationHistEntity </code> class defines managed beans
 * which provides functionality on the
 * <code>Payment Notification History Entity</code> Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Entity(name = "paymentsNotifHistory")
@Table(name = "APP_PAYMENTS_NOTIFICATION_HISTORY")
public class PaymentNotificationHistEntity implements Serializable {
	private static final long serialVersionUID = -5469994304896783582L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer Id;

	@Column(name = "senton")
	private String senton;

	@Column(name = "sentby")
	private String sentby;

	@Column(insertable = false, updatable = false, name = "paymentId")
	private int paymentId;

	@Column(insertable = false, updatable = false, name = "templateId")
	private int templateId;

	@Column(insertable = false, updatable = false, name = "userId")
	private int userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId", nullable = false)
	@JsonIgnore
	private PaymentEntity payments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "templateId", nullable = false)
	@JsonIgnore
	private ReferenceLookUpTemplateEntity lookuptemplates;

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

	public String getSenton() {
		return senton;
	}

	public void setSenton(String senton) {
		this.senton = senton;
	}

	public String getSentby() {
		return sentby;
	}

	public void setSentby(String sentby) {
		this.sentby = sentby;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public PaymentEntity getPayments() {
		return payments;
	}

	public void setPayments(PaymentEntity payments) {
		this.payments = payments;
	}

	public ReferenceLookUpTemplateEntity getLookuptemplates() {
		return lookuptemplates;
	}

	public void setLookuptemplates(ReferenceLookUpTemplateEntity lookuptemplates) {
		this.lookuptemplates = lookuptemplates;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

}