package com.medicine.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_id;
	
	@ManyToOne
	@JoinColumn(name="medicine_id")
	private Medicine medicine;
//	@Transient
//	private String medicinename;
//	public String getMedicinename() 
//	{
//		if(medicine!=null) 
//		{
//			return medicine.getName();
//			}
//		return medicinename;
//		}
//	public void setMedicinename(String medicinename) {
//		this.medicinename = medicinename;
//		}
	
	@ManyToOne
	@JoinColumn(name="medicine_name")
	private Medicine medicinename;
	public Medicine getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(Medicine medicinename) {
		this.medicinename = medicinename;
	}


	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private float amount;


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", medicine=" + medicine + ", medicinename=" + medicinename + ", user="
				+ user + ", amount=" + amount + ", quantity=" + quantity + ", status=" + status + ", paymentStatus="
				+ paymentStatus + ", date=" + date + ", paymentmethod=" + paymentmethod + "]";
	}

	


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}


	private Integer quantity;
	@Column(name="status")
	private String status;
	
	@Column(name="paymentStatus")
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

	public void setOrder_id(Long order_id) {
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
	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
		}
	public void setStock(int i) {
		// TODO Auto-generated method stub 
		}
	

	public Long getId() {
		// TODO Auto-generated method stub
		return medicine.getId();
	}
	}

