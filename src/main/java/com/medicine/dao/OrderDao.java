package com.medicine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {

	Order findByPaymentStatus(String paymentStatus);
	//List<Order> orders= Dao.findAll();
	//public List<Order> findByPaymentStatus(String paymentStatus);

}
