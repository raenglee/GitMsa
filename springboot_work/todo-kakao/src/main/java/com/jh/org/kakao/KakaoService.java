package com.jh.org.kakao;

import com.jh.org.error.UserException;
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
    private final Environment environment;
    private final JWTUtils jwtUtils;

    /*
     1. 카카오 https://kauth.kakao.com/oauth/token -> accessToken 발급
     2. 카카오 https://kapi.kakao.com/v2/user/me -> 유저정보 가져오기
     3. KakaoEntity -> 테이블 행삽입 -> 해당하는 이메일 검사...
     4. JWT(JSON Web Token) -> JWTUtils.createJWT(email) 해서 반환...
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

            // 해당하는 EMAIL 이 있으면..
            KakaoEntity dbKakaoEntity = kakaoRepository.findByEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
            if(dbKakaoEntity ==null) {
                KakaoEntity kakaoEntity = new ModelMapper().map(kakaoTokenDto, KakaoEntity.class);
                kakaoEntity.setEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
                kakaoEntity.setNickname(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
                kakaoEntity.setProfile_image(kakaoUserInfoDto.getProperties().getProfileImage());
                kakaoEntity.setThumbnail_image(kakaoUserInfoDto.getProperties().getThumbnailImage());
                kakaoEntity.setUserId(UUID.randomUUID().toString());
                kakaoRepository.save(kakaoEntity);
            }else{
                dbKakaoEntity.setNickname(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
                dbKakaoEntity.setProfile_image(kakaoUserInfoDto.getProperties().getProfileImage());
                dbKakaoEntity.setThumbnail_image(kakaoUserInfoDto.getProperties().getThumbnailImage());
                dbKakaoEntity.setUserId(UUID.randomUUID().toString());
                dbKakaoEntity.setAccess_token(kakaoTokenDto.getAccess_token());
                dbKakaoEntity.setRefresh_token(kakaoTokenDto.getRefresh_token());
                dbKakaoEntity.setExpires_in(kakaoTokenDto.getExpires_in());
                dbKakaoEntity.setRefresh_token_expires_in(kakaoTokenDto.getRefresh_token_expires_in());
                kakaoRepository.save(dbKakaoEntity);
            }
            String jwt = jwtUtils.createJwt(kakaoUserInfoDto.getKakaoAccount().getEmail());
            return jwt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    // 메시지 보내기 함수..
    // 1. jwt 내용 확인...(email 있는지..., 유효한토큰..) Email 가져오기..
    // 2. https://kapi.kakao.com/v2/api/talk/memo/default/send
    // headers = contectType accessToken
    // body template_object {   }
    // 우리가 발급한 JWT login..., AccessToken(유효시간)-> message X , RefreshToken(유효시간)


    public void messageSend(String jwt, String message) {
        String email = jwtUtils.getEmailFromJwt(jwt);

        RestTemplate restTemplate = new RestTemplate();
        // access 메세지 보내는 주소
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        // headers 만들기 -> 헤더에는 content-type과 access Token 필요
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //database에 해당되는 email이 없는 경우
        KakaoEntity kakaoEntity = kakaoRepository.findByEmail(email);
        if (kakaoEntity == null) {
            throw new UserException("could not find Email");
        }

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