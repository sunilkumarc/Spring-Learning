package com.example.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		log.info("INFO : Inside /");
		log.debug("DEBUG : Inside /");
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
