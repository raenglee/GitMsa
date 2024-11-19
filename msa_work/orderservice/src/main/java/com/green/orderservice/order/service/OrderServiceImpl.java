package com.green.orderservice.order.service;

import com.green.orderservice.error.OrderException;
import com.green.userservice.jwt.JwtUtils;
import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository; // UserRepository dependency injection
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(OrderRequest orderRequest) {
        String reqEmail = orderRequest.getEmail();

        orderRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new OrderException(String.format("이미 존재하는 email 메일입니다 \n회원가입 할 수 없습니다.%s", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = mapper.map(orderRequest, OrderEntity.class);
        orderEntity.setUserId(UUID.randomUUID().toString());
        orderEntity = orderRepository.save(orderEntity); // UserRepository 에서 UserEntity를 저장

        UserResponse userResponse = mapper.map(orderEntity,UserResponse.class);

        return userResponse;
    }

    @Override
    public OrderResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        OrderEntity orderEntity =
                orderRepository.findByEmailAndPassword(email, password)
                        .orElseThrow(
                                () ->
                                new OrderException("Invalid email or password")
                        );
        // 로그인한 유저가 있으면 loginResponse 객체 생성해서 controller에 반환
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUserId(orderEntity.getUserId());
        orderResponse.setAccessToken(jwtUtils.createAccessToken(orderEntity.getEmail(), orderEntity.getUserId()));
        orderResponse.setRefreshToken(jwtUtils.createRefreshToken(orderEntity.getEmail()));
        orderResponse.setEmail(orderEntity.getEmail());

        return orderResponse;
    }
}
