package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Medicine;
import com.medicine.service.MedicineService;

@RestController
@RequestMapping("/medicines")
@CrossOrigin(origins="*")
public class MedicineController {
	private final MedicineService medicineService;
	
	@Autowired
	public MedicineController(MedicineService medicineService) {
		this.medicineService=medicineService;
	}
	@GetMapping(path="/low-stock",consumes= {MediaType.ALL_VALUE})
	public ResponseEntity<List<Medicine>>getLowStockMedicine(){
		List<Medicine> lowStockMedicines= medicineService.getLowStockMedicine();
		return ResponseEntity.ok(lowStockMedicines);
	}
	@PostMapping(path="/add", consumes= {MediaType.ALL_VALUE})
	  public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
	    return ResponseEntity.ok(medicineService.addMedicine(medicine));
	  }
	  @GetMapping
	  public ResponseEntity<List<Medicine>> getAllMedicines() {
	    return ResponseEntity.ok(medicineService.getAllMedicines());
	  }
//	  @PutMapping("/{medicineId}")
//	  public ResponseEntity<Medicine> updateMedicine(@PathVariable Long medicineId, @RequestBody Medicine medicine) {
//	    return ResponseEntity.ok(medicineService.updateMedicine(medicineId, medicine));
//	  }
	  @PutMapping("/{id}/stock")
	  public ResponseEntity<Void> updateStock(@PathVariable Long id, @RequestParam("stock") int stock){
		  medicineService.updateStockById(id, stock);
		  return ResponseEntity.noContent().build();
	  }
}
