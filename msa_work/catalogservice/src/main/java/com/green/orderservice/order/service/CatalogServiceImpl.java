package com.green.orderservice.order.service;

import com.green.orderservice.error.CatalogException;
import com.green.userservice.jwt.JwtUtils;
import com.green.orderservice.order.jpa.CatalogEntity;
import com.green.orderservice.order.jpa.CatalogRepository;
import com.green.orderservice.order.vo.CatalogResponse;
import com.green.orderservice.order.vo.CatalogRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository; // UserRepository dependency injection
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(CatalogRequest catalogRequest) {
        String reqEmail = catalogRequest.getEmail();

        catalogRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new CatalogException(String.format("이미 존재하는 email 메일입니다 \n회원가입 할 수 없습니다.%s", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        CatalogEntity catalogEntity = mapper.map(catalogRequest, CatalogEntity.class);
        catalogEntity.setUserId(UUID.randomUUID().toString());
        catalogEntity = catalogRepository.save(catalogEntity); // UserRepository 에서 UserEntity를 저장

        UserResponse userResponse = mapper.map(catalogEntity,UserResponse.class);

        return userResponse;
    }

    @Override
    public CatalogResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        CatalogEntity catalogEntity =
                catalogRepository.findByEmailAndPassword(email, password)
                        .orElseThrow(
                                () ->
                                new CatalogException("Invalid email or password")
                        );
        // 로그인한 유저가 있으면 loginResponse 객체 생성해서 controller에 반환
        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setUserId(catalogEntity.getUserId());
        catalogResponse.setAccessToken(jwtUtils.createAccessToken(catalogEntity.getEmail(), catalogEntity.getUserId()));
        catalogResponse.setRefreshToken(jwtUtils.createRefreshToken(catalogEntity.getEmail()));
        catalogResponse.setEmail(catalogEntity.getEmail());

        return catalogResponse;
    }
}
