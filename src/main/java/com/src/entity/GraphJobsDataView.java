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
@Table(name = "APP_GRAPH_JOBS_DATA_VW")
public class GraphJobsDataView {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "SKILL")
	private String skill;

	@Column(name = "JOBCOUNT")
	private int count;

	
	@Column(name = "TYPE")
	private String type;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
