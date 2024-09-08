package com.medicine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.medicine.dao.OrderDao;
import com.medicine.dao.PaymentDao;
import com.medicine.entity.Order;
import com.medicine.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private OrderDao orderDao;
	public  Payment makePayment(long id,double amount,String paymentMethod)
	{
		Optional<com.medicine.entity.Order> order=orderDao.findById(id);
		Payment payment=new Payment();
		
		payment.setAmount(amount);
		payment.setMethod("Cash on delivery");
		payment.setOrder(order.get());
		payment.setStatus("Pending");
		return paymentDao.save(payment);
	}
	/*public Payment getByStatus(String paymentStatus){
		return paymentDao.getByStatus(paymentStatus);
		}*/

}
