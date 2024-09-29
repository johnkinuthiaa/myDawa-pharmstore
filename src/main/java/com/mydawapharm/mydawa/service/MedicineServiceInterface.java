package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.Medicine;

import java.util.List;

public interface MedicineServiceInterface {
    List<Medicine> getAllMedicine();
    List<Medicine> getMedicineByCategory(String category);
    List<Medicine> getMedicineByName(String name);
    List<Medicine> getMedicineByPurpose(String purpose);
    Medicine getMedicineById(Long id);
    Medicine createNewMedicineItem(Medicine medicine,Long id);
    Medicine updateMedicine(Medicine medicine,Long id);
    void deleteAllMedicine();
    void deleteMedicineById(Long id);
}
