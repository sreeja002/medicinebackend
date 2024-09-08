package com.medicine.dto;


import java.time.LocalDate;

import com.medicine.entity.Medicine;

public class OrderDto {
	private Long order_id;
	private Medicine medicine;
	private Integer quantity;
	private String status;
	private String paymentStatus;
	private LocalDate date;
	private String paymentmethod;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long Order_id) {
		this.order_id = order_id;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
