package com.mydawapharm.mydawa.repository;

import com.mydawapharm.mydawa.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
//    Medicine findByMedicineName(String medicineName);
}
