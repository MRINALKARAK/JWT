package com.jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LaptopDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int id ;
	private String cpuName;
	private int ram;
	private String laptopName;
	public int getId() {
		return id;
	}
	public String getCpuName() {
		return cpuName;
	}
	public int getRam() {
		return ram;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	@Override
	public String toString() {
		return "LaptopDetails [id=" + id + ", cpuName=" + cpuName + ", ram=" + ram + ", laptopName=" + laptopName
				+ ", getId()=" + getId() + ", getCpuName()=" + getCpuName() + ", getRam()=" + getRam()
				+ ", getLaptopName()=" + getLaptopName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public LaptopDetails(int id, String cpuName, int ram, String laptopName) {
		super();
		this.id = id;
		this.cpuName = cpuName;
		this.ram = ram;
		this.laptopName = laptopName;
	}
	public LaptopDetails() {
		super();
	}
	
}
