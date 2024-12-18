package com.ecommerce.order_service.dto.response;

import com.ecommerce.order_service.dto.response.base.BaseResponseDto;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class ProductResponseDto extends BaseResponseDto {
    private Long id;
    private String productName;
    private BigDecimal price;

}