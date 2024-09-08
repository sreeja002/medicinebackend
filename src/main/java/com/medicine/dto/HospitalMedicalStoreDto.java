package com.medicine.dto;

public class HospitalMedicalStoreDto 
{
	private Long id;
	private String name;
	private String area;
	public String getEmergencerequest() {
		return emergencerequest;
	}
	public void setEmergencerequest(String emergencerequest) {
		this.emergencerequest = emergencerequest;
	}
	private String emergencerequest;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

}
