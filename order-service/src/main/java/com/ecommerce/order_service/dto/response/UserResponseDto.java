package com.ecommerce.order_service.dto.response;

import com.ecommerce.order_service.dto.response.base.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto extends BaseResponseDto {
    private String name;
}
