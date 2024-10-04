package com.example.ex10.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDto joinDto){
        System.out.println(joinDto);
        loginService.join(joinDto);
        return "success";
    }
}
