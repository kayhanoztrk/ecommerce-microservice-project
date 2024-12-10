package com.ecommerce.order_service.dto.response.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
public class BaseResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date createdDate;

}
