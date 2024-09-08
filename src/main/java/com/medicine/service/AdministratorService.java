package com.medicine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.AdministratorDao;
import com.medicine.dto.AdministratorDto;
import com.medicine.entity.Administrator;
import com.medicine.entity.User;

@Service
public class AdministratorService {
	@Autowired
	AdministratorDao administratorDao;

	
	
	public AdministratorDto saveAdmin(AdministratorDto administratorDto) {
		
		Administrator user = new Administrator();
		user.setUsername(administratorDto.getUsername());
		user.setPassword(administratorDto.getPassword());
		
		administratorDao.save(user);
		
		
		return administratorDto;
	}
	
	public String createUser(AdministratorDto administratorDto) {
		
		Administrator user = new Administrator();
		user.setUsername(administratorDto.getUsername());
		String pass = administratorDto.getPassword();
		if(checkPasswordStrength(pass)) {
			System.out.println("GOOD !");
			
			user.setPassword(administratorDto.getPassword());
			user.setAdmin(true);
			
			administratorDao.save(user);
			return "Admin Added Successfully !";
		
		}else {
			return "BAD Password !";

		}
	}
	public boolean validateAdmin(String username, String password) {
		Administrator user= administratorDao.findByUsername(username);
		if(user != null&&user.getPassword().equals(password)&&user.isAdmin()) {
			return true;
		}
		return false;
	}
	public boolean checkPasswordStrength(String password) {
		boolean hasUpperCase = !password.equals(password.toLowerCase());
		boolean hasNumber = password.matches(".*\\d.*");
		boolean hasSpecialSymbol = !password.matches("[A-Za-z0-9 ]*");
		return password.length()>=6 && hasUpperCase && hasNumber && hasSpecialSymbol;
	}
	public long getUser(String username) {
		Administrator user = administratorDao.findByUsername(username);
		if(user.getAdmin_id() <= 0) {
			System.out.println("Admin Not Present");
			}return user.getAdmin_id();}

}
