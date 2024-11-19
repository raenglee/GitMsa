package com.green.userservice.user.service;

import com.green.userservice.error.UserException;
import com.green.userservice.jwt.JwtUtils;
import com.green.userservice.user.jpa.UserEntity;
import com.green.userservice.user.jpa.UserRepository;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserSerivceImpl implements UserService{

    private final UserRepository userRepository; // UserRepository dependency injection
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(UserRequest userRequest) {
        String reqEmail = userRequest.getEmail();

        userRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new UserException(String.format("이미 존재하는 email 메일입니다 \n회원가입 할 수 없습니다.%s", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        UserEntity userEntity = mapper.map(userRequest, UserEntity.class);
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity = userRepository.save(userEntity); // UserRepository 에서 UserEntity를 저장

        UserResponse userResponse = mapper.map(userEntity,UserResponse.class);

        return userResponse;
    }

    @Override
    public LoginResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        UserEntity userEntity =
                userRepository.findByEmailAndPassword(email, password)
                        .orElseThrow(
                                () ->
                                new UserException("Invalid email or password")
                        );
        // 로그인한 유저가 있으면 loginResponse 객체 생성해서 controller에 반환
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(userEntity.getUserId());
        loginResponse.setAccessToken(jwtUtils.createAccessToken(userEntity.getEmail(), userEntity.getUserId()));
        loginResponse.setRefreshToken(jwtUtils.createRefreshToken(userEntity.getEmail()));
        loginResponse.setEmail(userEntity.getEmail());

        return loginResponse;
    }
}
