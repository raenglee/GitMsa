package com.jh.org.kakao;

import com.jh.org.kakao.dto.KakaoMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
//        kakaoService.messageSend();
        // 2. openfeign
        // 새로운 메인 길....
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("msg")
    public ResponseEntity<String> messageSend(@RequestParam(value = "message") String message,
                                              @RequestHeader(value = "Authorization", required = false) String authorization
    ) {
        log.info(authorization);
        //b
        try {
            String jwt = authorization.split("Bearer ")[1];
            kakaoService.messageSend(jwt, message);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("jwt empty");
        }
        // jwt
//        kakaoService.messageSend(email, message);
        return ResponseEntity.ok("message send success");
    }


}
