package code.util;

import code.entity.PurchaseOrder;
import common.dto.OrderRequestDto;

public final class DtoToEntity {


    public static PurchaseOrder getpurchaseOrderEntityFromOrderRequestDto(OrderRequestDto orderRequestDto) {

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setUserId(orderRequestDto.getUserId());
        purchaseOrder.setAmount(orderRequestDto.getAmount());
        purchaseOrder.setProductId(orderRequestDto.getProductId());
//        purchaseOrder.setPaymentStatus(orderRequestDto.ge);
        return purchaseOrder;
    }
}
