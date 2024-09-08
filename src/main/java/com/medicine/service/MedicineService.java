package com.medicine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.MedicineDao;
import com.medicine.entity.Medicine;

@Service
public class MedicineService {
	private final MedicineDao medicineDao;
	
	@Autowired
	public MedicineService(MedicineDao medicineDao) {
		this.medicineDao=medicineDao;
	}
	
	public List<Medicine> getLowStockMedicine(){
			return medicineDao.finAllByLowStock(10);
	}
	
	public Medicine addMedicine(Medicine medicine) {
	    return medicineDao.save(medicine);
	  }
	  public List<Medicine> getAllMedicines() {
	    return medicineDao.findAll();
	  }
//	  public Medicine updateMedicine(Long medicineId, Medicine medicine) {
//	    Medicine existingMedicine = medicineDao.findById(medicineId).orElseThrow(() -> new IllegalArgumentException("Medicine not found"));
//	    
//	    existingMedicine.setName(medicine.getName());
//	    existingMedicine.setDescription(medicine.getDescription());
//	    existingMedicine.setStock(medicine.getStock());
//	    return medicineDao.save(medicine);
//	    }
	  public void updateStockById(Long id, int stock) {
		  Optional<Medicine> optionalMedicine= medicineDao.findById(id);
		  if(optionalMedicine.isPresent()) {
			  Medicine medicine = optionalMedicine.get();
			  medicine.setStock(stock);
			  medicineDao.save(medicine);
			  
		  }else {
			  throw new IllegalArgumentException("Medicine not found");
		  }
	  }

}
