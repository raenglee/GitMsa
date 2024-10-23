package com.jh.org.kakao;

import com.jh.org.KakaoUtils;
import com.jh.org.filter.JWTUtils;
import com.jh.org.kakao.dto.KakaoTokenDto;
import com.jh.org.kakao.dto.KakaoUserInfoDto;
import com.jh.org.kakao.jpa.KakaoEntity;
import com.jh.org.kakao.jpa.KakaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoRepository kakaoRepository;
    private final Environment environment;  // 야믈에 있는 oauth 클라이언트 아이디, 시크릿 가져오는것
    private final JWTUtils jwtUtils;

    /*
     * 1. 카카오 "https://kauth.kakao.com/oauth/token" -> access Token 발급
     * 2. 카카오 "https://kapi.kakao.com/v2/user/me" -> user 정보 가져오기
     * 3. KakaoEntity -> 테이블 행 삽입 -> 해당하는 이메일 검사
     * 4. JWT(JSON Wen Token) -> JWTUtils.createJWT(eamil)해서 반환
     */

    public String getToken(String code) {

        try {
            // 토큰 가져오기 시작
            String url = "https://kauth.kakao.com/oauth/token";
            RestTemplate restTemplate = new RestTemplate();
            // header 내용
            MultiValueMap headers = new LinkedMultiValueMap();
            headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            // body 내용
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", environment.getProperty("oauth.kakao.client_id"));
            body.add("redirect_uri", "http://localhost:5173/oauth");
            body.add("code", code);
            body.add("client_secret", environment.getProperty("oauth.kakao.client_secret"));

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<KakaoTokenDto> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, KakaoTokenDto.class);
            log.info("result {}", result);
            KakaoTokenDto kakaoTokenDto = result.getBody();
            // 토큰 가져오기 끝

            // 유저 정보 가져오기 시작
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + kakaoTokenDto.getAccess_token());
            ResponseEntity<KakaoUserInfoDto> res = restTemplate.exchange("https://kapi.kakao.com/v2/user/me"
                    , HttpMethod.GET
                    , new HttpEntity<>(null, httpHeaders)
                    , KakaoUserInfoDto.class
            );

            KakaoUserInfoDto kakaoUserInfoDto = res.getBody();

            // 유저 정보 가져오기 끝

            KakaoEntity kakaoEntity = new ModelMapper().map(kakaoTokenDto, KakaoEntity.class);

            kakaoEntity.setEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
            kakaoEntity.setNickname(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
            kakaoEntity.setProfile_image(kakaoUserInfoDto.getProperties().getProfileImage());
            kakaoEntity.setThumbnail_image(kakaoUserInfoDto.getProperties().getThumbnailImage());

            //user ID는 중복안되게 생성 => 자바 제공 랜덤 UUID 생성
            kakaoEntity.setUserId(UUID.randomUUID().toString());

            // db저장
            kakaoRepository.save(kakaoEntity);

            // email만 JWT token에 담는 것
            String jwt = jwtUtils.createJwt(kakaoEntity.getEmail());
            return jwt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "false";

    }

    public void messageSend(String jwt, String message) {
        String email = jwtUtils.getEmailFromJwt(jwt);

        RestTemplate restTemplate = new RestTemplate();
        // access 메세지 보내는 주소
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        // headers 만들기 -> 헤더에는 content-type과 access Token 필요
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(email);
        headers.add("Authorization", "Bearer " + kakaoEntity.getAccess_token());

        // body message
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("template_object", String.format(KakaoUtils.messageString(), email, message));

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        log.info("msg 카카오톡 메시지 전송 성공....." + result.toString());

        // 메시지 보내기 끝
    }
}