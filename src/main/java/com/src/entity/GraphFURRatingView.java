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
@Table(name = "APP_GRAPH_FURATING_DATA_VW")
public class GraphFURRatingView {

	@Id
	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name = "STARRATE")
	private double starrate;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getStarrate() {
		return starrate;
	}

	public void setStarrate(double starrate) {
		this.starrate = starrate;
	}

	
}
