package com.medicine.dto;

import javax.persistence.Column;

public class MedicineDto {
	private Long id;
	private String name;
	private Integer stock;
	private Integer minimumStock1;
	private String description;
	private float price;
	
	public Integer getMinimumStock1() {
		return minimumStock1;
	}
	public void setMinimumStock1(Integer minimumStock1) {
		this.minimumStock1 = minimumStock1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getMinimumStock() {
		return minimumStock1;
	}
	public void setMinimumStock(Integer minimumStock) {
		this.minimumStock1 = minimumStock;
	}
	private Integer minimumStock;

}
