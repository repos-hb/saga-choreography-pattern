package code.service;

import common.dto.OrderRequestDto;
import common.dto.OrderStatus;
import common.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderKafkaService {

    @Autowired
    private Sinks.Many<OrderEvent> sinks;

    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        OrderEvent orderEvent = new OrderEvent(orderRequestDto, orderStatus);
        sinks.tryEmitNext(orderEvent);
    }
}
