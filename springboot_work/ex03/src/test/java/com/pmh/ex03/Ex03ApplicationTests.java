package com.pmh.ex03;

import com.pmh.ex03.user.User;
import com.pmh.ex03.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Ex03ApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        System.out.println("실행");
        //save: insert 실행
        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("gg@naver.com")
                .password("password")
                .wdate(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    @Test
    void selectTest() {
        userRepository.findAll()
                .stream()
                .forEach(System.out::println);
    }
}
