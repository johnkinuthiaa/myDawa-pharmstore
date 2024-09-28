package com.mydawapharm.mydawa.controller;

import com.mydawapharm.mydawa.model.Medicine;
import com.mydawapharm.mydawa.service.MedicineServiceInterface;
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
    public List<Medicine> getAllMedicine(){
        return service.getAllMedicine();
    }
    @GetMapping("/get-medicine-by-id")
    public Medicine getMedicineById(@RequestParam Long id){
        return service.getMedicineById(id);
    }
    @PostMapping("/add/new-medicine")
    public Medicine createNewMedicineItem(@RequestBody Medicine medicine,@RequestParam Long id){
        return service.createNewMedicineItem(medicine,id);

    }
    @DeleteMapping("/delete-all")
    public void deleteAllMedicine(){
        service.deleteAllMedicine();
    }
}

