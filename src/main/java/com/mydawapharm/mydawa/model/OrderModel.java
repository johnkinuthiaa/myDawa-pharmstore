package com.mydawapharm.mydawa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class OrderModel {
    @Id
    private Long orderId;
    private LocalDate orderDate;
    private String orderStatus;
    private Double total;
    private String orderAddress;

    public OrderModel(){}
    public OrderModel(Long orderId,LocalDate orderDate,String orderStatus, Double total,String orderAddress){
        this.orderId=orderId;
        this.orderDate=orderDate;
        this.orderStatus=orderStatus;
        this.orderAddress=orderAddress;
    }
    public void setOrderId(Long orderId){
        this.orderId=orderId;
    }
    public Long getOrderId(){
        return orderId;
    }
    public void setOrderDate(LocalDate orderDate){
        this.orderDate=orderDate;
    }
    public LocalDate getOrderDate(){
        return orderDate;
    }
    public void setOrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }
    public String getOrderStatus(){
        return orderStatus;
    }
    public void setTotal(Double total){
        this.total=total;
    }
    public Double getTotal(){
        return total;
    }
    public void setOrderAddress(String orderAddress){
        this.orderAddress=orderAddress;
    }
    public String getOrderAddress(){
        return orderAddress;
    }

}
