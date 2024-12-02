package com.green.userservice.feign;

import com.green.userservice.user.vo.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="order-server", url ="${order-service-url}")
public interface OrderClient {
    // http://localhost:40004/order-service/anclkerjnalskdcfjnqlwecurhnlkAJCNlaksdjfnrc/order
    //[
    //    {
    //        "productId": "p-003",
    //        "qty": 10,
    //        "unitPrice": 1000,
    //        "totalPrice": 10000,
    //        "userId": "3d2b7c1e-309c-4143-8846-d06bd72a75bd",
    //        "orderId": "70eb6b92-3744-4677-861d-dd804a60ba94",
    //        "createdAt": "2024-11-28T01:17:30.785+00:00"
    //    },
    //    {
    //        "productId": "p-002",
    //        "qty": 10,
    //        "unitPrice": 1000,
    //        "totalPrice": 10000,
    //        "userId": "3d2b7c1e-309c-4143-8846-d06bd72a75bd",
    //        "orderId": "071a25d8-c563-44c4-9745-91ec1608a3bd",
    //        "createdAt": "2024-11-28T02:42:40.137+00:00"
    //    },
    //    {
    //        "productId": "p-001",
    //        "qty": 10,
    //        "unitPrice": 1000,
    //        "totalPrice": 10000,
    //        "userId": "3d2b7c1e-309c-4143-8846-d06bd72a75bd",
    //        "orderId": "335e4fd8-e520-4403-957f-5eea156b03e1",
    //        "createdAt": "2024-11-28T02:42:44.235+00:00"
    //    }
    //]
    @GetMapping("order-service/{userId}/order")
    List<OrderResponse> getOrders(@PathVariable(value = "userId")String userId);
}
