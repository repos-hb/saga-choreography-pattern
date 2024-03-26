package common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Integer orderId;

    private Integer userId;

    private Integer amount;

    private Integer productId;

    private OrderStatus orderStatus;
}
