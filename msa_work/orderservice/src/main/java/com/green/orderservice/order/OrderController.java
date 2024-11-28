package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 해당하는 사용자 주문하기
    @PostMapping("/{userId}/order")
    public ResponseEntity<OrderResponse> userOrder(@PathVariable String userId,
                                                   @RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.order(orderRequest, userId);
        return ResponseEntity.ok(orderResponse);
    }

    // 해당하는 사용자 주문목록보기
    @GetMapping("/{userId}/order")
    public ResponseEntity<List<OrderResponse>> userOrders(@PathVariable String userId) {
        List<OrderResponse> orderResponses = orderService.list(userId);
        return ResponseEntity.ok(orderResponses);
    }


}
