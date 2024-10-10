package com.example.org.login;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class JoinDto implements Serializable {

    private String name;
    private String email;
    private String password;
    private int age;
}
