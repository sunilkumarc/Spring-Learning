package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicles.Vehicle;

@RestController
public class HomeController {

	@Autowired
	@Qualifier(value = "car")
	Vehicle vehicle1;
	
	@Autowired
	@Qualifier(value = "bike")
	Vehicle vehicle2;
	
	@RequestMapping("/")
	public String home() {
		return "Welcome! Success Ahead!";
	}
	
	@RequestMapping("/car")
	public String car() {
		return vehicle1.getName();
	}
	
	@RequestMapping("/bike")
	public String bike() {
		return vehicle2.getName();
	}
}
