package com.ecommerce.order_service.dto.response;

import com.ecommerce.order_service.dto.response.base.BaseResponseDto;
import lombok.Data;
import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class OrderResponseDto extends BaseResponseDto {
    private Long orderId;
    private List<ProductResponseDto> productIdList;
    private UserResponseDto user;
}
