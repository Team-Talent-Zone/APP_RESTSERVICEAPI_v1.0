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
@Table(name = "APP_GRAPH_USERSERVICE_DATA_VW")
public class GraphUserServiceDataView {

	@Id
	@Column(name = "ID")
	private String Id  ;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "COUNT")
	private int count;

	@Column(name = "TOTAL")
	private int total;

	@Column(name = "TYPE")
	private String type;

	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
	
}
