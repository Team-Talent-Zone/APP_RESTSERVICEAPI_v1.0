package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The <code> WidgetNotificationHistoryEntity </code> class defines a POJO that
 * provides back-end functionality for the *
 * <code>Widget Notification History Entity</code>.
 * 
 * @author Shanoor
 * @version 1.0.
 *
 */
@Entity(name = "widgetNotificationHistory")
@Table(name = "APP_DESIGN_WIDGET_NOTIFICATION_HISTORY")
public class WidgetNotificationHistoryEntity implements Serializable {

	private static final long serialVersionUID = -8422384748896744231L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(insertable = true, updatable = false, name = "userId")
	private Integer userId;

	@Column(insertable = true, updatable = false, name = "widgetId")
	private int widgetId;

	@Column(insertable = true, updatable = false, name = "templateId")
	private int templateId;

	@Column(name = "senton")
	private String senton;

	@Column(name = "sentby")
	private String sentby;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
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

}
