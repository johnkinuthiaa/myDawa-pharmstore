package com.mydawapharm.mydawa.service;

import com.mydawapharm.mydawa.model.OrderModel;

import java.util.List;

public interface OrderServiceInterface {
    List<OrderModel> getAllOrders();
    List<OrderModel> getOrderByStatus(String status);
    OrderModel createNewOrder(OrderModel orderModel,Long id);
    OrderModel updateExistingOrder(OrderModel orderModel,Long id);
    void deleteOrderById(Long id);
    void deleteAllOrders();
}
