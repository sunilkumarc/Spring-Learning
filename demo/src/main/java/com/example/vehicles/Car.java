package com.example.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	@Override
	public String getName() {
		return "This is a Car";
	}
}
