package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> AllBellNotificationsView </code> class defines managed beans
 * which provides functionality on the
 * <code>Bell Notification View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_ALL_BELL_NOTIFCATION")
public class AllBellNotificationsView {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "MSG")
	private String msg;

	@Column(name = "VISIBILITY")
	private String visibility;

	@Column(name = "UID")
	private Integer uid;
	
	@Column(name = "SUBCATEGORY")
	private String subcategory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	
	
}
