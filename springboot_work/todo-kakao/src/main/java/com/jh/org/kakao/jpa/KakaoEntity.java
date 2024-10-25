package com.jh.org.kakao.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class KakaoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String userId;
    private String nickname;
    private String profile_image;
    private String thumbnail_image;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String access_token;
    @JsonIgnore
    private String token_type;
    @JsonIgnore
    private String refresh_token;
    @JsonIgnore
    private String expires_in;
    @JsonIgnore
    private String scope;
    @JsonIgnore
    private String refresh_token_expires_in;
}
