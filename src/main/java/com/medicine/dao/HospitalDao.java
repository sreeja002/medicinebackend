package com.medicine.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medicine.entity.Hospital;

@Repository
public interface HospitalDao extends CrudRepository <Hospital,Long>{
	
	List<Hospital> findAll();

	List<Hospital> findBylocation(String location);

}
