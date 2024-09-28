package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.Medicine;
import com.mydawapharm.mydawa.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements MedicineServiceInterface{
    private final MedicineRepository repository;

    public MedicineService(MedicineRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Medicine> getAllMedicine(){
        return repository.findAll();
    }
    @Override
    public Medicine getMedicineById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("medicine with given id was not found");
        }
        return repository.findById(id).orElse(null);
    }
    @Override
    public Medicine createNewMedicineItem(Medicine medicine,Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("item already exists");
        }
        return repository.save(medicine);
    }
    @Override
    public void deleteAllMedicine(){
        repository.deleteAll();
    }
}
