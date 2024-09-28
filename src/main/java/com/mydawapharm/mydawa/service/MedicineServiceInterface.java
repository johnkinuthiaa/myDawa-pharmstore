package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.Medicine;

import java.util.List;

public interface MedicineServiceInterface {
    List<Medicine> getAllMedicine();
//    Medicine getMedicineByCategory()->learn streams
    Medicine getMedicineById(Long id);
    Medicine createNewMedicineItem(Medicine medicine,Long id);
    void deleteAllMedicine();
}
