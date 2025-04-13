package com.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.entity.LaptopDetails;
@Repository
public interface LaptopRepo extends JpaRepository<LaptopDetails, Integer>{

	
	public List<LaptopDetails> findByLaptopName(String LaptopName);
}
