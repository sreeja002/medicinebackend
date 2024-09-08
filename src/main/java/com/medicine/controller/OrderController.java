package com.medicine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.OrderDao;
import com.medicine.entity.Medicine;
import com.medicine.entity.Order;
import com.medicine.service.OrderService;

@RequestMapping("/orders")
@RestController 
@CrossOrigin(origins="*")
public class OrderController{
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MedicineDao medicineDao;
	@PostMapping("/placeOrder")
	public ResponseEntity<String>
	placeOrder(@RequestBody Order order){
		try{
			orderService.placeOrder(order);
			System.out.println("Order"+order);
			return ResponseEntity.ok().body("Order placed successfully");
			//System.out.println("Order Placed");
			} 
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	
	@GetMapping(path="/allOrders",consumes= {MediaType.ALL_VALUE})
	public List<Order> 
	findAllOrders(){
		return orderDao.findAll();
	}
//	@PostMapping(path="/accept",consumes= {MediaType.ALL_VALUE})
//	public ResponseEntity<List<String>> acceptOrder(@RequestBody Order order)
//	{
//		try {order.setPaymentStatus("Payment successful");
//		orderService.acceptOrder(order);
//		List<String> response = new ArrayList<>();
//		response.add("Payment successful");
//		response.add("Order accepted");
//		return ResponseEntity.ok().body(response);
//		}
//		catch (Exception e) {
//			return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
//			}
//		}
//	@PostMapping(path="/reject",consumes= {MediaType.ALL_VALUE})
//	public ResponseEntity<List<String>> rejectOrder(@RequestBody Order order) 
//	{
//		try {order.setPaymentStatus("Payment failed");
//		orderService.rejectOrder(order);
//		List<String> response = new ArrayList<>();
//		response.add("Payment failed.");response.add("Order rejected");
//		return ResponseEntity.ok().body(response);
//		}
//		catch (Exception e) {
//			return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
//			}
	@PutMapping(path="/accept",consumes= {MediaType.ALL_VALUE})
	public ResponseEntity<String> acceptOrder(@RequestBody Order order) {
		try {
			// set order ID and payment status
			order.setOrder_id(order.getOrder_id());
			order.setPaymentStatus("Payment pending(COD)");
			//String medicinename = order.getMedicinename();
			Long medicineId = order.getId();
			Medicine medicine = medicineDao.findById(medicineId).orElse(null);
			//Medicine medicine = medicineDao.findByName(medicinename);
			if (medicine == null) 
			{
				order.setPaymentStatus("Payment failed");
				order.setStatus("Order Rejected");
				order.setUser(order.getUser());
				orderDao.save(order);
				return ResponseEntity.ok("Payment failed\nMedicine not found");
				}
			else if (medicine.getStock() < order.getQuantity()) 
			{
				order.setPaymentStatus("Payment failed");
				order.setStatus("Order Rejected");
				order.setUser(order.getUser());
				orderDao.save(order);
				return ResponseEntity.ok("Payment failed\nNot enough stock");
				}
			else {
				int currentStock = medicine.getStock();
				medicine.setStock(currentStock - order.getQuantity());
				order.setStatus("Order Accepted");
				order.setUser(order.getUser());
				orderDao.save(order);
				medicineDao.save(medicine);
				return ResponseEntity.ok("Payment pending\nOrder accepted");
				}
			}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing order");
			}
		}
	}
	