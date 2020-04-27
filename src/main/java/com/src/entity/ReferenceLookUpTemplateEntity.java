package com.src.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The <code> ReferenceLookUpTemplateEntity </code> class defines managed beans
 * which provides functionality on the
 * <code>Reference LookUp Template Entity</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 * 
 *          <pre>
 * ------------------------------------------------------------------------------
 * Date         Who        Sprint     Description
 * ------------------------------------------------------------------------------
 * 				Ishaq		4		  Initial Version.
 * 4/17/2020    Shanoor     6         Adding PaymentNotificationHistEntity dependency 
 * 									  and Updating SerialVersion ID.
 * ------------------------------------------------------------------------------
 *          </pre>
 *
 */
@Entity(name = "lookuptemplates")
@Table(name = "APP_REFERENCELOOKUP_TEMPLATES")
public class ReferenceLookUpTemplateEntity implements Serializable {

	private static final long serialVersionUID = -5511208762323597546L;

	@Id
	@Column(name = "TEMPLATEID")
	private int templateid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "URL")
	private String url;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SHORTKEY")
	private String shortkey;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "lookuptemplates")
	private PaymentNotificationHistEntity paymentsNotifHistory;

	public int getTemplateid() {
		return templateid;
	}

	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortkey() {
		return shortkey;
	}

	public void setShortkey(String shortkey) {
		this.shortkey = shortkey;
	}

	public PaymentNotificationHistEntity getPaymentsNotifHistory() {
		return paymentsNotifHistory;
	}

	public void setPaymentsNotifHistory(PaymentNotificationHistEntity paymentsNotifHistory) {
		this.paymentsNotifHistory = paymentsNotifHistory;
	}

}