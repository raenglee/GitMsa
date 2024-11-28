package com.green.orderservice.order.service;

import com.green.orderservice.error.OrderException;
import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository; // UserRepository dependency injection

    @Override
    public OrderResponse order(OrderRequest orderRequest, String userId) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductId(orderRequest.getProductId());
        orderEntity.setQty(orderRequest.getQty());
        orderEntity.setUnitPrice(orderRequest.getUnitPrice());
        orderEntity.setOrderId(UUID.randomUUID().toString());
        orderEntity.setUserId(userId);
        orderEntity.setTotalPrice(orderRequest.getUnitPrice() * orderRequest.getQty());
        OrderEntity dbOrderEntity = orderRepository.save(orderEntity);

        return new ModelMapper().map(dbOrderEntity, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> list(String userId) {
        List<OrderEntity> orderEntities
                = orderRepository.findAllByUserId(userId);
        List<OrderResponse> orderResponses = new ArrayList<OrderResponse>();
        orderEntities.stream().forEach(orderEntity ->
                        orderResponses.add(new ModelMapper().map(orderEntity, OrderResponse.class))
                );
        return orderResponses;
    }
}
