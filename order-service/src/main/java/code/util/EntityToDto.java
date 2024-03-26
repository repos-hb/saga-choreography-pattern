package code.util;

import code.entity.PurchaseOrder;
import common.dto.OrderResponseDto;

public class EntityToDto {
    public static OrderResponseDto getOrderResponseDtoFromPurchaseOrderEntity(PurchaseOrder purchaseOrder) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setUserId(purchaseOrder.getUserId());
        orderResponseDto.setOrderId(purchaseOrder.getId());
        orderResponseDto.setOrderStatus(purchaseOrder.getOrderStatus());
        orderResponseDto.setAmount(purchaseOrder.getAmount());
        orderResponseDto.setProductId(purchaseOrder.getProductId());
//        purchaseOrder.setPaymentStatus(orderResponseDto.getp);
        return orderResponseDto;
    }
}
