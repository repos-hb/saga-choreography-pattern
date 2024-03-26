package code.controller;

import code.entity.PurchaseOrder;
import code.service.OrderService;
import code.util.DtoToEntity;
import code.util.EntityToDto;
import common.dto.OrderRequestDto;
import common.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<OrderResponseDto> getAll(){
        List<PurchaseOrder> purchaseOrderList = orderService.getAllOrders();
        List<OrderResponseDto> orderResponseDtoList = purchaseOrderList.stream()
                .map(EntityToDto::getOrderResponseDtoFromPurchaseOrderEntity)
                .collect(Collectors.toList());
        return orderResponseDtoList;

    }
}
