package com.ecommerce.product_service.dto.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class ProductResponseDto {
    private Long id;
    private String productName;
    private BigDecimal price;

}
