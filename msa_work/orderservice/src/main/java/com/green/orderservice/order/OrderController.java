package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService userService;

    @PostMapping("join")
    public ResponseEntity<UserResponse> joinUser(@RequestBody OrderRequest orderRequest) {

        UserResponse userResponse = userService.join(orderRequest);
        System.out.println(userResponse);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("login")
    public ResponseEntity<OrderResponse> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        OrderResponse orderResponse = userService.login(email,password);

        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {
        return ResponseEntity.ok(null);
    }

}
