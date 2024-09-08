package com.medicine.service;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicine.dto.OrderDto;

@SpringBootTest
class OrderServiceTest {
	@Autowired
	private OrderService orderService;

	@Test
	void testGetAllOrders() {
		List<OrderDto> orders = orderService.getAllOrders(); 
		assertThat(orders);
		
	}
}
