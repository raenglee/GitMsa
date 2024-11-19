package com.green.orderservice.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<CatalogEntity,Long> {

    // select * from users where email =?;
    Optional<CatalogEntity> findByEmail(String reqEmail);

    // select * from users where email = ? and password = ?;
    Optional<CatalogEntity> findByEmailAndPassword(String email, String password);
}
