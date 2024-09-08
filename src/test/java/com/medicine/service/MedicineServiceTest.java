package com.medicine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicine.entity.Medicine;

@SpringBootTest
class MedicineServiceTest {
	@Autowired
	private MedicineService medicineService;
	@Test
	void test() {
		
	}

	@Test
	void testGetLowStockMedicine() {
		List<Medicine> lowStockMedicines = medicineService.getLowStockMedicine();
		assertEquals(0,lowStockMedicines.size());
		}
	}
