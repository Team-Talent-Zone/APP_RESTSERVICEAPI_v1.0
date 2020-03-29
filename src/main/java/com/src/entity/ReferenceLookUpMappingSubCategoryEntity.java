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
 * The <code> ReferenceLookUpMappingSubCategoryEntity </code> class defines
 * managed beans which provides functionality on the
 * <code>Reference LookUp Mapping Sub Category Entity</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity(name = "referencelookupmappingsubcategories")
@Table(name = "APP_REFERENCELOOKUP_MAPPING_SUBCATEGORIES")
public class ReferenceLookUpMappingSubCategoryEntity implements Serializable {
	private static final long serialVersionUID = -4091877317851339980L;

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Integer Id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "KEY")
	private String key;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "SHORTKEY")
	private String shortkey;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mapId", nullable = false)
	@JsonIgnore
	private ReferenceLookUpMappingEntity referencelookupmapping;

	@Column(insertable = false, updatable = false, name = "mapId")
	private int mapId;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public ReferenceLookUpMappingEntity getReferencelookupmapping() {
		return referencelookupmapping;
	}

	public void setReferencelookupmapping(ReferenceLookUpMappingEntity referencelookupmapping) {
		this.referencelookupmapping = referencelookupmapping;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShortkey() {
		return shortkey;
	}

	public void setShortkey(String shortkey) {
		this.shortkey = shortkey;
	}

}