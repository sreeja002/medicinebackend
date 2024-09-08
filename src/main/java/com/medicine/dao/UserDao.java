package com.medicine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.entity.User;


public interface UserDao extends JpaRepository<User,Long>{
	
	User findByUsername(String username);
	

}
