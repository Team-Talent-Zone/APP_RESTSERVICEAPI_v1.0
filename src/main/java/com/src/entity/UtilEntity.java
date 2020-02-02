package com.src.entity;

import java.io.Serializable;

public class UtilEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fromuser;

	private String touser;

	private String subject;

	private String body;

	private String[] array;

	private String templateurl;
	
	private int lastreturncode;
	
	private String lastserverresponse;

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public String getTemplateurl() {
		return templateurl;
	}

	public void setTemplateurl(String templateurl) {
		this.templateurl = templateurl;
	}

	public int getLastreturncode() {
		return lastreturncode;
	}

	public void setLastreturncode(int lastreturncode) {
		this.lastreturncode = lastreturncode;
	}

	public String getLastserverresponse() {
		return lastserverresponse;
	}

	public void setLastserverresponse(String lastserverresponse) {
		this.lastserverresponse = lastserverresponse;
	}
	
	 
}