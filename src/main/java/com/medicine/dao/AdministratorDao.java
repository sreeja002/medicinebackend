package com.medicine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.medicine.entity.Administrator;


public interface AdministratorDao extends JpaRepository<Administrator, Long>{
	Administrator findByUsername(String username);

}
