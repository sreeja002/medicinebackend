package com.medicine.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.medicine.entity.Payment;

@Repository
public interface PaymentDao extends CrudRepository<Payment,Long>{
	
	Payment findByid(long id);
	//Payment getByStatus(String paymentStatus);

}
