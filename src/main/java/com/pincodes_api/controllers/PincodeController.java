package com.pincodes_api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pincodes_api.db.pincodes;
import com.pincodes_api.services.PincodeService;


@RestController
public class PincodeController implements ErrorController{

	@Autowired
	PincodeService ps;
	
	@RequestMapping("/error")
    public ModelAndView handleError()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
 
    public String getErrorPath() {
        return "/error";
    }
	
	@GetMapping("/")
	public Map<String,String> intro(){
		Map<String, String> map = new HashMap<>();
		map.put("Made By", "Devansh Mohata");
		map.put("Repository Link", "https://github.com/MISHANDLED/Pincodes_API");
		
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
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
	