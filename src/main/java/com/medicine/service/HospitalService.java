package com.medicine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.HospitalDao;
import com.medicine.dao.UserDao;
import com.medicine.entity.Hospital;
import com.medicine.entity.Medicine;
import com.medicine.entity.User;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private UserDao userDao;
	
	public List<Hospital> getAllHospitals(String location)
	{
		return hospitalDao.findBylocation(location);
	}
	
	public List<Hospital> getAllBylocation(String location) {
		return hospitalDao.findBylocation(location);
		
	}
//	public String sendEmergencyRequest(String emergencyRequest,String location){
//		List<Hospital> listHospitals =hospitalDao.findBylocation(location);
//		for(Hospital hospital:listHospitals){
//			hospital.setEmergencyRequest(hospital.getEmergencyRequest());
//			hospitalDao.save(hospital);
//			}
//		return "request sent";
//		}
	public String sendEmergencyRequest(String emergencyReq,String location, Long user_id){
		Optional<User> user=userDao.findById(user_id);
		List<Hospital> listHospitals =hospitalDao.findBylocation(location);
		for(Hospital h:listHospitals){
			h.setEmergencyRequest(emergencyReq);
			h.setUser(user.get());
			System.out.println(h.getEmergencyRequest());
			hospitalDao.save(h);
			}
		
		return "request sent";
		}
	public List<Hospital> getAllHospitals() {
		return hospitalDao.findAll();
		}
}
