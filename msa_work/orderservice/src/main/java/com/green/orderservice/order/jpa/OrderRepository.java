package com.green.orderservice.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findAllByUserId(String userId);

}
