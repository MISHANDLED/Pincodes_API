package com.pincodes_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pincodes_api.db.pincodes;
import com.pincodes_api.repos.Pincode_repo;

@Service
public class PincodeService {
	
	@Autowired
	Pincode_repo temp;
	
	public List<pincodes> getAll() {
		return temp.findAll();
	}
	
	public pincodes getOne(int pin) {
		return temp.findById(pin).get();
	}

}