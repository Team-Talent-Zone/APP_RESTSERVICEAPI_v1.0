package com.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The <code> GraphFURRatingView </code> class defines managed beans
 * which provides functionality on the
 * <code>Graph Skilled Worker Rating View</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Entity
@Immutable
@Table(name = "APP_GRAPH_SKILLBASE_PROFIT_VW")
public class GraphSkillBaseDataView {

	@Id
	@Column(name = "SUBCATEGORYLABEL")
	private String subcategorylabel;

	@Column(name = "TOTALCOMPANYAMOUNT")
	private float totalcompanyamount;

	public String getSubcategorylabel() {
		return subcategorylabel;
	}

	public void setSubcategorylabel(String subcategorylabel) {
		this.subcategorylabel = subcategorylabel;
	}

	public float getTotalcompanyamount() {
		return totalcompanyamount;
	}

	public void setTotalcompanyamount(float totalcompanyamount) {
		this.totalcompanyamount = totalcompanyamount;
	}

	
}
