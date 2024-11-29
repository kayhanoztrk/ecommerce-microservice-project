package com.ecommerce.product_service.dto.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class ProductCreateRequest {

    private String productName;
    private BigDecimal price;
}
