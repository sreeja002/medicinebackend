package com.medicine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.HospitalMedicalStoreDao;
import com.medicine.dao.UserDao;
import com.medicine.entity.Hospital;
import com.medicine.entity.HospitalMedicalStore;
import com.medicine.entity.User;

@Service
public class HospitalMedicalStoreService {
	
	@Autowired
	private HospitalMedicalStoreDao  hospitalMedicalStoreDao;
	
	@Autowired
	private UserDao userDao;
		
		/*public List<HospitalMedicalStore> getAllHospitalstore(String area)
		{
			return hospitalMedicalStoreDao.findByarea(area);
		}*/

		public List<HospitalMedicalStore> getAllByarea(String area) {
			return hospitalMedicalStoreDao.findByarea(area);
		}
//		public String getEmergencyRequest(String emergencyRequest,String area){
//			List<HospitalMedicalStore> listhospitalMedicalStore = hospitalMedicalStoreDao.findByarea(area);
//			for(HospitalMedicalStore hospital:listhospitalMedicalStore){
//				hospital.setEmergencyRequest("need medicine");
//				hospitalMedicalStoreDao.save(hospital);
//				}
//			return "request sent";
//			}
		public String sendEmergencyRequest(String emergencyReq,String area,Long user_id)
		{
		Optional<User> user=userDao.findById(user_id);
		List<HospitalMedicalStore> listhospitalMedicalStore =hospitalMedicalStoreDao.findByarea(area);
		for(HospitalMedicalStore h:listhospitalMedicalStore){
		h.setEmergencyRequest(emergencyReq);
		h.setUser(user.get());
		System.out.println(h.getEmergencyRequest());
		hospitalMedicalStoreDao.save(h);
		}
		return "request sent";
		}
		public List<HospitalMedicalStore> getAllMedStores() {
			return hospitalMedicalStoreDao.findAll();
			}

}
