package com.src.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The <code> ReferenceStaticDataEntity </code> class defines managed beans
 * which provides functionality on the <code>Reference Static Data Entity</code>
 * Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity(name = "referencestaticdata")
@Table(name = "APP_REFERENCE_STATIC_DATA")
public class ReferenceStaticDataEntity implements Serializable {
	private static final long serialVersionUID = 2246765437553431986L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "KEY")
	private String key;

	@Column(name = "CONTENT")
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
