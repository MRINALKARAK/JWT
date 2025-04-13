package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.LaptopDetails;
import com.jwt.service.LaptopService;

@RestController
@RequestMapping("/api")
public class LaptopDetailsController {

	@Autowired
	private LaptopService laptopService;
	
	@PostMapping("/save")
	public Object saveLaptopDetails(@RequestBody LaptopDetails lap) {
		return laptopService.saveLaptopDetails(lap);
		
	}
	@GetMapping("/laptop")
	public Object saveLaptopDetails(@RequestParam String name) {
		return laptopService.getByLaptopname(name);
		
	}
	
	@PutMapping("/update/{id}")
	public Object updateLaptopDetails(@PathVariable int id,@RequestBody LaptopDetails laptopDetails) {
		return laptopService.updateLaptopDetails(id,laptopDetails);
	}
	
}
