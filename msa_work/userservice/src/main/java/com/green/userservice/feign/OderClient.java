package com.green.userservice.feign;

import com.green.userservice.user.vo.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-server", url = "{http://localhost)"
public interface OrderClient {

    @GetMapping("order-service/{userId}/order")
    List<OrderResponse> getTest(@PathVariable(value = "userId") String userId);
}
