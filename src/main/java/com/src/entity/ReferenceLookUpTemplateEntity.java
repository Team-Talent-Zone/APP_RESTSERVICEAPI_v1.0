package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The <code> ReferenceLookUpTemplateEntity </code> class defines managed beans
 * which provides functionality on the <code>Reference LookUp Template Entity</code>
 * Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity(name = "lookuptemplates")
@Table(name = "APP_REFERENCELOOKUP_TEMPLATES")
public class ReferenceLookUpTemplateEntity implements Serializable {
	private static final long serialVersionUID = 7821990018500690486L;

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
	
	public int getTemplateid() {
		return templateid;
	} 

	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}

	public String getShortkey() {
		return shortkey;
	}

	public void setShortkey(String shortkey) {
		this.shortkey = shortkey;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}