package com.green.orderservice.order.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderResponse sendMesaage(String topic, OrderEntity orderEntity) {

        ObjectMapper mapper = new ObjectMapper();
        String msg = null;
        try {
            msg = mapper.writeValueAsString(orderEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topic, msg);

        log.info("Send message: {} topic {}", msg, topic);

        return new ModelMapper().map(orderEntity, OrderResponse.class);
    }

}
