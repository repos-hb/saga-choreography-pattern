package code.controller;

import code.entity.PurchaseOrder;
import code.service.OrderService;
import code.util.DtoToEntity;
import code.util.EntityToDto;
import common.dto.OrderRequestDto;
import common.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        PurchaseOrder purchaseOrder = orderService.placeOrder(orderRequestDto);
        OrderResponseDto orderResponseDto = EntityToDto.getOrderResponseDtoFromPurchaseOrderEntity(purchaseOrder);
        return orderResponseDto;
    }
}
