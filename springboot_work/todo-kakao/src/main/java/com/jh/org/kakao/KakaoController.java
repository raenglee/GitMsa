package com.jh.org.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kakao")
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("login")
    public ResponseEntity<String> kakaoCode(@RequestParam(value = "code") String code) {
        // 1. restTemplate
        String jwt = kakaoService.getToken(code);
        if(jwt.equals("fail"))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail to get jwt");
        else
            return ResponseEntity.ok(jwt);
//        kakaoService.messageSend();
        // 2. openfeign

        // 새로운 메인 길....

    }


    @GetMapping("msg")
    public ResponseEntity<String> messageSend(@RequestParam(value = "message") String message,
                                              @RequestHeader(value = "Authorization",required = false) String authorization
    ) {
//        log.info(authorization);
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im11bmdzdW5zYW5nQGtha2FvLmNvbSIsInJvbGUiOiJST0xFX0FETUlOIiwiaWF0IjoxNzI5NjQ5MzkzLCJleHAiOjE3Mjk3MzU3OTN9.5weQe0m9e9RIS9tOUPTx23N0Wv-3Jt7nr_GFIf8akbU
        try {
            String jwt = authorization.split("Bearer ")[1];
            kakaoService.messageSend(jwt, message);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("jwt empty");
        }
        // jwt
//        kakaoService.messageSend(email, message);
        return ResponseEntity.ok("message send success");
    }
}