package com.mydawapharm.mydawa.repository;

import com.mydawapharm.mydawa.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel,Long> {

}
