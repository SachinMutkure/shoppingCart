package com.sam.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author webwerks
 *
 */
@Entity
@Table(name = "DISTRICTS")
public class DistrictEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "district")
	private String district;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}	

}
