package com.green.userservice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    // select * from users where email =?;
    Optional<UserEntity> findByEmail(String reqEmail);

    // select * from users where email = ? and password = ?;
    Optional<UserEntity> findByEmailAndPassword(String email, String password);

    // select * from users where user_id = ?;
    Optional<UserEntity> findByUserId(String userId);
}
