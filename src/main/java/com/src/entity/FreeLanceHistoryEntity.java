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
 * The <code> FreeLanceHistoryEntity </code> class defines managed beans which
 * provides functionality on the <code>FreeLance History Entity</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity(name = "freelancehistoryentity")
@Table(name = "APP_USER_FREELANCE_HISTORY")
public class FreeLanceHistoryEntity implements Serializable {
	private static final long serialVersionUID = -1697844064430609298L;

	@Id
	@Column(name = "EVENTID")
	@GeneratedValue
	private Integer eventId;

	@Column(insertable = false, updatable = false, name = "USERID")
	private Integer userid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	private UserEntity userdetails;

	@Column(name = "DECISIONBY")
	private String decisionby;

	@Column(name = "DECISIONON")
	private String decisionon;
	
	@Column(name = "DECISIONBYEMAILID")
	private String decisionbyemailid;

	@Column(name = "BGSTATUS")
	private String bgstatus;

	@Column(name = "BGCOMMENT")
	private String bgcomment;

	@Column(name = "ISLOCKED")
	private boolean islocked;

	@Column(name = "MANAGERID")
	private Integer managerid;

	@Column(name = "CSSTID")
	private Integer csstid;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public UserEntity getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserEntity userdetails) {
		this.userdetails = userdetails;
	}

	public String getBgstatus() {
		return bgstatus;
	}

	public void setBgstatus(String bgstatus) {
		this.bgstatus = bgstatus;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCsstid() {
		return csstid;
	}

	public void setCsstid(Integer csstid) {
		this.csstid = csstid;
	}

	public boolean isIslocked() {
		return islocked;
	}

	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}

	public String getDecisionby() {
		return decisionby;
	}

	public void setDecisionby(String decisionby) {
		this.decisionby = decisionby;
	}

	public String getDecisionon() {
		return decisionon;
	}

	public void setDecisionon(String decisionon) {
		this.decisionon = decisionon;
	}

	public String getBgcomment() {
		return bgcomment;
	}

	public void setBgcomment(String bgcomment) {
		this.bgcomment = bgcomment;
	}

	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	} 

	public String getDecisionbyemailid() {
		return decisionbyemailid;
	}

	public void setDecisionbyemailid(String decisionbyemailid) {
		this.decisionbyemailid = decisionbyemailid;
	}
	
	

}
