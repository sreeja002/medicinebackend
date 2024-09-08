package com.medicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Order;
import com.medicine.entity.Payment;
import com.medicine.service.PaymentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/make")
	public Payment makePayment(@RequestParam("id")long id,
			                   @RequestParam("amount")double amount,
	
			                   @RequestParam("method") String method)
	{
		System.out.println(amount);
		return paymentService.makePayment(id,amount,method);
	}
	/*@GetMapping("/payment-status/{paymentStatus}")
	public Payment getByStatus(@PathVariable String paymentStatus) {
		return paymentService.getByStatus(paymentStatus);
		}*/

}
