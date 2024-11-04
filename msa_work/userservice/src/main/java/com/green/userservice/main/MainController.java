package com.green.userservice.main;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final Environment environment;

    @GetMapping("/env")
    public String getEnvironmentVariables() {
        return String.format(" token.secret = %s", environment.getProperty("token.secret"));
    }

}
