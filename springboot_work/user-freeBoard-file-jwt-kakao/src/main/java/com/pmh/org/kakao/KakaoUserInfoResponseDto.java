package com.pmh.org.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pmh.org.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString
public class KakaoUserInfoResponseDto {

    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public User toEntity() {
        User member = User.builder()
                .email(kakaoAccount.getEmail())
                .name(kakaoAccount.getProfile().getNickname())
                .profileImageUrl(kakaoAccount.getProfile().getThumbnailImageUrl())
                .build();
        return member;
    }

    @Getter @Setter
    @ToString
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Getter @Setter
        @ToString
        public static class Profile {

            private String nickname;

            @JsonProperty("thumbnail_image_url")
            private String thumbnailImageUrl;

        }

    }

}