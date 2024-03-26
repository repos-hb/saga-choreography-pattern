package code.service;

import code.entity.PurchaseOrder;
import code.repository.OrderRepository;
import code.util.DtoToEntity;
import common.dto.OrderRequestDto;
import common.dto.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public PurchaseOrder placeOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder purchaseOrder = DtoToEntity.getpurchaseOrderEntityFromOrderRequestDto(orderRequestDto);
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        return orderRepository.save(purchaseOrder);
    }
}
