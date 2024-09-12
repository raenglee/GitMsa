package com.example.ex07.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //select * from where email = ?
    //Userservice에서 findbyemail 호출하면 됨
    Optional<User> findByEmail(String email);

}
