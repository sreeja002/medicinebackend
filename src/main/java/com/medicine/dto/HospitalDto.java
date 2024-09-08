package com.medicine.dto;

public class HospitalDto {
	private Long id;
	private String name;
	private String location;
	private String emergencerequest;
	public String getEmergencerequest() {
		return emergencerequest;
	}
	public void setEmergencerequest(String emergencerequest) {
		this.emergencerequest = emergencerequest;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
	