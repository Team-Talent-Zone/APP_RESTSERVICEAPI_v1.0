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
 * The <code> PaymentNotificationHistEntity </code> class defines managed beans which provides
 * functionality on the <code>Payment Notification History Entity</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity(name = "paymentsNotifHistory")
@Table(name = "APP_PAYMENTS_NOTIFICATION_HISTORY")
public class PaymentNotificationHistEntity implements Serializable {
	private static final long serialVersionUID = 7248859776417761151L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer Id;

	@Column(name = "sendon")
	private String sendon;

	@Column(name = "sendby")
	private String sendby;

	@Column(insertable = false, updatable = false, name = "paymentId")
	private int paymentId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId", nullable = false)
	@JsonIgnore
	private PaymentEntity payments;

	@Column(insertable = false, updatable = false, name = "templateId")
	private int templateId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "templateId", nullable = false)
	@JsonIgnore
	private ReferenceLookUpTemplateEntity lookuptemplates;

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

	public String getSendon() {
		return sendon;
	}

	public void setSendon(String sendon) {
		this.sendon = sendon;
	}

	public String getSendby() {
		return sendby;
	}

	public void setSendby(String sendby) {
		this.sendby = sendby;
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

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public ReferenceLookUpTemplateEntity getLookuptemplates() {
		return lookuptemplates;
	}

	public void setLookuptemplates(ReferenceLookUpTemplateEntity lookuptemplates) {
		this.lookuptemplates = lookuptemplates;
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