package com.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.entity.LaptopDetails;
import com.jwt.repository.LaptopRepo;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepo laptopRepo; 
	
	public ResponseEntity<List<LaptopDetails>> getAllLaptopDetails(){
		try {
			List <LaptopDetails> data=laptopRepo.findAll();
			
			return new ResponseEntity<List<LaptopDetails>>(data,HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<LaptopDetails>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	public ResponseEntity<LaptopDetails> saveLaptopDetails(LaptopDetails laptopDetails){
		try {
			LaptopDetails data=laptopRepo.save(laptopDetails);
			
			return new ResponseEntity<LaptopDetails>(data,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<LaptopDetails>(HttpStatus.BAD_REQUEST);

		}
	}
	
	public ResponseEntity<Optional<LaptopDetails>> findLaptopDtailsById(int id){
	
		try {
			Optional<LaptopDetails> data=laptopRepo.findById(id);	
			return new ResponseEntity<Optional<LaptopDetails>>(data,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<Optional<LaptopDetails>>(HttpStatus.BAD_REQUEST);

		}
	}

	public Object getByLaptopname(String name) {
		// TODO Auto-generated method stub
		return laptopRepo.findByLaptopName(name);
	}

	public ResponseEntity<LaptopDetails> updateLaptopDetails(int id, LaptopDetails laptopDetails) {
		// TODO Auto-generated method stub
		
		
			Optional<LaptopDetails> oldData=laptopRepo.findById(id);
			if (oldData.isPresent()) {
				LaptopDetails oldDataa=oldData.get();
				oldDataa.setCpuName(laptopDetails.getCpuName());
				oldDataa.setId(id);
				oldDataa.setLaptopName(laptopDetails.getLaptopName());
				oldDataa.setRam(laptopDetails.getRam());
				return new ResponseEntity<>(oldDataa,HttpStatus.OK);
				
			}
		
			else {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	
	}
	}
	

