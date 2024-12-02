package com.green.userservice.user;

import com.green.userservice.feign.FirstClient;
import com.green.userservice.user.service.UserService;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FirstClient firstClient;

    @GetMapping("long-work")
    @Timed("long.work")
    public String longWork(){
        try {
            Thread.sleep(1000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Long work completed";
    }
    @GetMapping("short-work")
    @Timed("short.work")
    public String shortwork(){
        try {
            Thread.sleep(10); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "short work completed";
    }

    @GetMapping("test")
    public String test(){
        System.out.println("통신시작");
        System.out.println(firstClient.getTest());
        System.out.println("통신끝");
        return "UserService";
    }

    @PostMapping("join")
    public ResponseEntity<UserResponse> joinUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.join(userRequest);
        System.out.println(userResponse);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserResponse>> listUser(){
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("login")
    public ResponseEntity<LoginResponse> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        LoginResponse loginResponse = userService.login(email,password);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("getuser/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "userId") String userId){
        UserResponse userResponse = userService.getUser(userId);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {
        return ResponseEntity.ok(null);
    }

}
