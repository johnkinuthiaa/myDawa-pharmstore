package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.Medicine;
import com.mydawapharm.mydawa.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Medicine> getMedicineByPurpose(String purpose){
        return repository.findAll().stream()
                .filter(medicine ->medicine.getPurpose().toLowerCase().contains(purpose.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Medicine> getMedicineByCategory(String category) {
        return repository.findAll().stream()
                .filter(medicine -> medicine.getCategory().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Medicine> getMedicineByName(String name) {
        return repository.findAll().stream()
                .filter(medicine -> medicine.getMedicineName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Medicine getMedicineById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("medicine with given id was not found");
        }
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<Medicine> getMedicineByBrand(String brand){
        return repository.findAll().stream()
                .filter(medicine ->medicine.getBrand().toLowerCase().contains(brand.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Medicine createNewMedicineItem(Medicine medicine,Long id){
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("item already exists");
        }
        return repository.save(medicine);
    }
    @Override
    public Medicine updateMedicine(Medicine medicine,Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("cannot update the item since it doesnt exist");
        }else{
            repository.deleteById(id);
        }
        return repository.save(medicine);
    }
    @Override
    public  void deleteMedicineById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("medicine not found");
        }else {
            repository.deleteById(id);
        }
    }
    @Override
    public void deleteAllMedicine(){
        repository.deleteAll();
    }
}
