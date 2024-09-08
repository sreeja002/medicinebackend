package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Hospital;
import com.medicine.entity.Medicine;
import com.medicine.service.HospitalService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/list")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/hospitals/{location}")
	public List<Hospital> getAllHospitals(@PathVariable String location)
	{
		return hospitalService.getAllBylocation(location);
	}
//	@PutMapping("/hosiptals/{location}")
//	public String EmergencyRequest(@PathVariable String location,@RequestBody String emergencyRequest)
//	{
//		return hospitalService.sendEmergencyRequest(emergencyRequest, location);
//		//return "request sent";
//		}
	@PutMapping("/hospitals/{location}/{emergencyReq}/{user_id}")
	public String EmergencyRequest(@PathVariable String emergencyReq,@PathVariable String location,@PathVariable Long user_id)
	{
		return hospitalService.sendEmergencyRequest(emergencyReq, location,user_id);
		//return "request sent";
		}
	@GetMapping(path="/hospitals", consumes= {MediaType.ALL_VALUE})
	public List<Hospital> getAllHospitals(){
		return hospitalService.getAllHospitals();
	}

}
