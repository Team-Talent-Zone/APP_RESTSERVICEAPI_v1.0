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
@Table(name = "APP_GRAPH_VOLIATION_DATA_VW")
public class GraphSkillWorkerVoliationDataView {

	@Id
	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name = "VOLIATIONCOUNT")
	private int voliationcount;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getVoliationcount() {
		return voliationcount;
	}

	public void setVoliationcount(int voliationcount) {
		this.voliationcount = voliationcount;
	}

	
}
