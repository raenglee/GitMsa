package com.pmh.ex01.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("aa")
    public String aa(){
        return "aa";
    }

    @GetMapping("bb")
    public String bb(){
        return "ggggg";
    }
}
