package com.medicine.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.OrderDao;
import com.medicine.dto.OrderDto;
import com.medicine.entity.Medicine;
import com.medicine.entity.Order;

@Service
@CrossOrigin(origins="*")
public class OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MedicineDao medicineDao;
	
	public void placeOrder(Order order)
	{
		order.setStatus("Ordered");
		order.setQuantity(order.getQuantity());
		order.setMedicine(order.getMedicine());
		order.setPaymentmethod(order.getPaymentmethod());
		order.setUser(order.getUser());
		orderDao.save(order);
	}
	public List<OrderDto> getAllOrders() {
		// TODO Auto-generated method stub
		Iterable<Order> iterable = orderDao.findAll();
		List<OrderDto> orders = StreamSupport.stream(iterable.spliterator(),false).map(order->{
			OrderDto dto = new OrderDto();
			BeanUtils.copyProperties(order, dto);
			return dto;
		}).collect(Collectors.toList());
		return null;
	}
//	public void acceptOrder(Order order) {
//		order.setPaymentStatus("Payment successful");
//		order.setStatus("Order Accepted");
//		orderDao.save(order);
//		}
//	public void rejectOrder(Order order) {
//		order.setPaymentStatus("Payment failed");
//		order.setStatus("Order Rejected");
//		orderDao.save(order);
	
	//	}
	/*public List<Order> getOrdersByPaymentStatus(String paymentStatus) {
		return orderDao.findByPaymentStatus(paymentStatus);}
	public Order getOrdersByPaymentStatus(String paymentStatus){
		return orderDao.findByPaymentStatus(paymentStatus);
		}*/
	public void acceptOrder(Order order) {
		order.setOrder_id(order.getOrder_id());
		order.setPaymentStatus("Payment pending");
		//String medicinename = order.getMedicinename();
		//Long medicineId = order.getId();
		//Medicine medicine = medicineDao.findById(medicineId).orElse(null);
		//Medicine medicine = medicineDao.findByName(medicinename);
		Long medicineId = order.getId();
		Medicine medicine = medicineDao.findById(medicineId).orElse(null);
		if (medicine != null) {
			int currentStock = medicine.getStock();
			if (currentStock >= order.getQuantity()) {
				medicine.setStock(currentStock - order.getQuantity());
				order.setStatus("Order Accepted");
				order.setUser(order.getUser());
				orderDao.save(order);
				//orderDao.save(medicine);
				}
			else {
				order.setPaymentStatus("Payment failed");
				order.setStatus("Order Rejected");
				order.setUser(order.getUser());
				orderDao.save(order);
				}
			}
		else {
			order.setPaymentStatus("Payment failed");
			order.setStatus("Order Rejected");
			order.setUser(order.getUser());
			orderDao.save(order);
			}
			}
	}
	
