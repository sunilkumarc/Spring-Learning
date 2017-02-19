package com.example.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	@Override
	public String getName() {
		return "This is a Bike";
	}
}
