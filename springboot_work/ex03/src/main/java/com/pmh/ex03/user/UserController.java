package com.pmh.ex03.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController  // url 요청(맵핑) 하는 클래스
@RequestMapping("user")  //주소 줄에 user로 시작 함 (http://localhost:8080/user/select)
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userRepository;

    @GetMapping("select")
    public List<User> select() {
        return userRepository.findAll();
    }

    @PostMapping("insert")
    public String insert(@RequestBody User user){
        System.out.println("실행");
        //save: insert 실행
//        User user = User.builder()
//                .name("홍길동")
//                .age(20)
//                .email("gg@naver.com")
//                .password("password")
//                .wdate(LocalDateTime.now())
//                .build();

        userRepository.save(user);
        return "ok";
    }
}
