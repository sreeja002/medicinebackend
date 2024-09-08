package com.medicine.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.medicine.dto.ReorderDto;
@SpringBootTest
class ReorderServiceTest {
	@Autowired
	private ReorderService reorderService;

	@Test
	void testGetAllReorders() {
		List<ReorderDto> reorders = reorderService.getAllReorders(); 
		assertThat(reorders);
			
		}
	}

