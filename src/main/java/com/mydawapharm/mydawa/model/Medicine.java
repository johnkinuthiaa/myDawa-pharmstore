package com.mydawapharm.mydawa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicine {
    @Id
    private Long medicineId;
    private String medicineName;
    private String medicineImage;
    private String brand;
    private String purpose;
    private String category;
    private String description;

    public void setMedicineId(Long medicineId){
        this.medicineId=medicineId;
    }
    public Long getMedicineId(){
        return medicineId;
    }

    public void setMedicineName(String medicineName){
        this.medicineName=medicineName;
    }
    public String getMedicineName(){
        return medicineName;
    }
    public void setMedicineImage(String medicineImage){
        this.medicineImage=medicineImage;
    }
    public String getMedicineImage(){
        return medicineImage;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setPurpose(String purpose){
        this.purpose=purpose;
    }
    public String getPurpose(){
        return purpose;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public String getCategory(){
        return category;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
