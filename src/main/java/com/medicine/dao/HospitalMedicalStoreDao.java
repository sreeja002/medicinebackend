package com.medicine.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.medicine.entity.HospitalMedicalStore;

public interface HospitalMedicalStoreDao extends CrudRepository<HospitalMedicalStore,Long>{
	
	List<HospitalMedicalStore> findAll();
	//List<HospitalMedicalStore> findByarea(String area);
	List<HospitalMedicalStore> findByarea(String area);

}
