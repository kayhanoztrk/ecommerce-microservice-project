package com.ecommerce.order_service.dto.request;

import lombok.Data;
import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class OrderCreateRequest {
    private List<Long> productId;
    private Long userId;
}
