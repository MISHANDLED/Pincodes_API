package com.pincodes_api.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pincodes")
public class pincodes {
	
	@Id
	@Column(name="pincode")
	int pincode;
	
	@Column(name="district")
	String district;
	
	@Column(name="state")
	String state;

	public pincodes() {
		super();
	}

	public pincodes(int pincode, String district, String state) {
		super();
		this.pincode = pincode;
		this.district = district;
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
