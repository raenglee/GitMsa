package com.green.userservice.user;

import com.green.userservice.user.service.UserService;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("join")
    public ResponseEntity<UserResponse> joinUser(@RequestBody UserRequest userRequest) {

        UserResponse userResponse = userService.join(userRequest);
        System.out.println(userResponse);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("login")
    public ResponseEntity<LoginResponse> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        LoginResponse loginResponse = userService.login(email,password);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {
        return ResponseEntity.ok(null);
    }

}
