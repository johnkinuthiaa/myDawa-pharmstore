package com.mydawapharm.mydawa.controller;

import com.mydawapharm.mydawa.model.OrderModel;
import com.mydawapharm.mydawa.service.OrderServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")

public class OrderController {
    private final OrderServiceInterface service;
    public OrderController(OrderServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all-orders")
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        return new ResponseEntity<>(service.getAllOrders(), HttpStatus.OK);
    }
    @GetMapping("/get/by-status")
    public ResponseEntity<List<OrderModel>> getOrderByStatus(@RequestParam String status){
        return new ResponseEntity<>(service.getOrderByStatus(status),HttpStatus.OK);
    }
    @PostMapping("/create/new-order")
    public ResponseEntity<OrderModel> createNewOrder(@RequestBody OrderModel orderModel,@RequestParam Long id){
        return new ResponseEntity<>(service.createNewOrder(orderModel,id),HttpStatus.CREATED);
    }
    @PutMapping("/update/by-id")
    public ResponseEntity<OrderModel> updateExistingOrder(@RequestBody OrderModel orderModel,@RequestParam Long id){
        return new ResponseEntity<>(service.updateExistingOrder(orderModel,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/by-id")
    public void deleteOrderById(@RequestParam Long id){
        service.deleteOrderById(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllOrders(){
        service.deleteAllOrders();
    }
}
