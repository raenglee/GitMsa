package com.green.orderservice.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    // select * from users where email =?;
    Optional<OrderEntity> findByEmail(String reqEmail);

    // select * from users where email = ? and password = ?;
    Optional<OrderEntity> findByEmailAndPassword(String email, String password);
}
