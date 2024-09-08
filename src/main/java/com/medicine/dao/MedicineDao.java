package com.medicine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicine.entity.Medicine;


public interface MedicineDao extends JpaRepository<Medicine,Long> {
	@Query("select m from Medicine m where m.stock<=:minimumStock")
	List<Medicine> finAllByLowStock(@Param("minimumStock")int minimumStock);

	Medicine findByName(String medicinename);

}