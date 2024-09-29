package com.mydawapharm.mydawa.controller;

import com.mydawapharm.mydawa.model.Medicine;
import com.mydawapharm.mydawa.service.MedicineServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/my-dawa")
public class MedicineController {
    private final MedicineServiceInterface service;
    public MedicineController(MedicineServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Medicine>>  getAllMedicine(){
        return new ResponseEntity<>(service.getAllMedicine(), HttpStatus.OK);
    }
    @GetMapping("/get/purpose")
    public ResponseEntity<List<Medicine>> getMedicineByPurpose(@RequestParam String purpose){
        return new ResponseEntity<>(service.getMedicineByPurpose(purpose),HttpStatus.OK);

    }
    @GetMapping("/get/category")
    public ResponseEntity<List<Medicine>>getMedicineByCategory( @RequestParam String category){
        return new ResponseEntity<>(service.getMedicineByCategory(category),HttpStatus.OK);
    }
    @GetMapping("/get/name")
    public ResponseEntity<List<Medicine>> getMedicineByName(@RequestParam String name){
        return new ResponseEntity<>(service.getMedicineByName(name),HttpStatus.OK);
    }
    @GetMapping("/get-medicine-by-id")
    public ResponseEntity<Medicine> getMedicineById(@RequestParam Long id){
        return new ResponseEntity<>(service.getMedicineById(id),HttpStatus.OK) ;
    }
    @GetMapping("/get/brand")
    public ResponseEntity<List<Medicine>> getMedicineByBrand(@RequestParam String brand){
        return new ResponseEntity<>(service.getMedicineByBrand(brand),HttpStatus.OK);
    }
    @PostMapping("/add/new-medicine")
    public ResponseEntity<Medicine> createNewMedicineItem(@RequestBody Medicine medicine,@RequestParam Long id){
        return new ResponseEntity<>(service.createNewMedicineItem(medicine,id),HttpStatus.CREATED) ;

    }
    @PutMapping("/update-item")
    public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine,@RequestParam Long id){
        return new ResponseEntity<>(service.updateMedicine(medicine,id),HttpStatus.OK) ;
    }
    @DeleteMapping("/delete-by-id")
    public void deleteMedicineById(@RequestParam Long id){
        service.deleteMedicineById(id);
    }
    @DeleteMapping("/delete-all")
    public void deleteAllMedicine(){
        service.deleteAllMedicine();
    }
}

