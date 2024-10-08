package com.pmh.org.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class KakaoController {

    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    @GetMapping("/kakao/login")
    public String loginCallback(String code) {
        log.info("code = {}",code);
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
        KakaoTokenDto.Request kakaoTokenRequestDto = KakaoTokenDto.Request.builder()
                // Todo 재발급 받아야함..
//                .client_id("asdfasdf")
//                .client_secret("qwerqwer")
                .grant_type("authorization_code")
                .code(code)
                .redirect_uri("http://localhost:5173/kakaologin")
                .build();
        KakaoTokenDto.Response kakaoToken = kakaoTokenClient.requestKakaoToken(contentType, kakaoTokenRequestDto);
        log.info("kakaoToken = {}",kakaoToken);
        KakaoUserInfoResponseDto responseDto
                = kakaoUserInfoClient.getKakaoUserInfo(contentType, "Bearer "+kakaoToken.getAccess_token());
        log.info("responseDto = {}",responseDto);
        return "kakao toekn : " + kakaoToken;
    }
}
