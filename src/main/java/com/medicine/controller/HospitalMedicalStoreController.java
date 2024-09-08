package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Hospital;
import com.medicine.entity.HospitalMedicalStore;
import com.medicine.service.HospitalMedicalStoreService;

@RequestMapping("/lists")
@RestController
@CrossOrigin(origins="*")
public class HospitalMedicalStoreController {
	
	@Autowired
	private HospitalMedicalStoreService hospitalMedicalStoreService;
	
	@GetMapping("/medicalstore/{area}")
	public List<HospitalMedicalStore> getAllhospitalsstore(@PathVariable String area)
	{
		return hospitalMedicalStoreService.getAllByarea(area);
	}
//	@GetMapping("/medicalstore/{emergencyRequest}/{location}")
//	  public String getEmergencyRequest(@PathVariable String emergencyRequest,@PathVariable String location){
//		  return "request sent";
//		  }
	@PutMapping("/medicalstore/{area}/{emergencyReq}/{user_id}")
	public String EmergencyRequest(@PathVariable String emergencyReq,@PathVariable String area,@PathVariable Long user_id)
	{
	return hospitalMedicalStoreService.sendEmergencyRequest(emergencyReq, area,user_id);
	//return "request sent";}
	}
	@GetMapping(path="/medicalstore", consumes= {MediaType.ALL_VALUE})
	public List<HospitalMedicalStore> getAllMedStores(){
		return hospitalMedicalStoreService.getAllMedStores();
	}
}
