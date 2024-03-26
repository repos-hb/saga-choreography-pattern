package code.service;

import code.entity.PurchaseOrder;
import code.repository.OrderRepository;
import code.util.DtoToEntity;
import common.dto.OrderRequestDto;
import common.dto.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderKafkaService kafkaService;

    public PurchaseOrder placeOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder purchaseOrderEntity = DtoToEntity.getpurchaseOrderEntityFromOrderRequestDto(orderRequestDto);
        PurchaseOrder purchaseOrder = orderRepository.save(purchaseOrderEntity);
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);

        // publish order-event with status ORDER_CREATED
        orderRequestDto.setOrderId(purchaseOrder.getId());
        kafkaService.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);

        return purchaseOrder;
    }

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
