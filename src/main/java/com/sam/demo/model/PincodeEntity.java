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
@Table(name = "PINCODE")
public class PincodeEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "pincode")
	private String pincode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
