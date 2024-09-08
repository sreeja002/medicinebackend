package com.medicine.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.ReorderDao;
import com.medicine.dto.ReorderDto;
import com.medicine.entity.Reorder;

@Service
public class ReorderService {
	@Autowired
	private ReorderDao reorderDao;
//	@Autowired
//	private ReorderDto reorderDto;
	
	public void placeOrder(Reorder reorder){
		Reorder re = new Reorder();
		re.setStatus(reorder.getStatus());
		reorder.setQuantity(reorder.getQuantity());
		reorder.setMedicine(reorder.getMedicine());
		reorder.setUser(reorder.getUser());
		reorderDao.save(reorder);
		}
	public List<ReorderDto> getAllReorders() {
		// TODO Auto-generated method stub
		Iterable<Reorder> iterable = reorderDao.findAll();
		List<ReorderDto> reorders = StreamSupport.stream(iterable.spliterator(),false).map(reorder->{
			ReorderDto dto = new ReorderDto();
			BeanUtils.copyProperties(reorder, dto);
			return dto;
		}).collect(Collectors.toList());
		return null;
	}
	public void acceptReorder(Reorder reorder){
		reorder.setStatus("Reorder Accepted");
		reorderDao.save(reorder);
		}
	public void rejectReorder(Reorder reorder){
		reorder.setStatus("Reorder Rejected");
		reorderDao.save(reorder);
	}

}
