package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.OrderModel;
import com.mydawapharm.mydawa.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderServiceInterface{
    private final OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository=repository;
    }
    @Override
    public List<OrderModel> getAllOrders() throws RuntimeException{
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("order list is empty");
        }
        return repository.findAll();
    }
    @Override
    public List<OrderModel> getOrderByStatus(String status){
        return repository.findAll().stream()
                .filter(orderModel ->orderModel.getOrderStatus().toLowerCase().contains(status.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public OrderModel createNewOrder(OrderModel orderModel,Long id) throws RuntimeException{
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("order already exists");
        }
        return repository.save(orderModel);
    }
    @Override
    public OrderModel updateExistingOrder(OrderModel orderModel,Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("order does not exist");
        }else {
            repository.deleteById(id);
        }
        return repository.save(orderModel);
    }
    @Override
    public void deleteOrderById(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else {
            throw new RuntimeException("item not found");
        }
    }
    @Override
    public void deleteAllOrders(){
        repository.deleteAll();
    }
}
