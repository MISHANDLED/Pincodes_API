package com.pincodes_api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pincodes_api.db.pincodes;
import com.pincodes_api.services.PincodeService;


@RestController
public class PincodeController {

	@Autowired
	PincodeService ps;
	
	@GetMapping("/")
	public Map<String,String> intro(){
		Map<String, String> map = new HashMap<>();
		map.put("Made By", "Devansh Mohata");
		return map;
	}
	
	@GetMapping("/pincodes")
	public List<pincodes> getAllPins(){
		return ps.getAll();
	}
	
	@GetMapping("/pincodes/{pin}")
	public ResponseEntity<pincodes> getOnePin(@PathVariable(value="pin") int pin) {
		try {
			pincodes val = ps.getOne(pin);
			return new ResponseEntity<pincodes>(val, HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("**")
	public ResponseEntity<String> invalidHandle(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
	}
	
}
	