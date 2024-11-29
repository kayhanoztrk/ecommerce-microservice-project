package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.request.OrderCreateRequest;
import com.ecommerce.order_service.dto.response.OrderResponseDto;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface OrderService {
    List<OrderResponseDto> findAll();
    OrderResponseDto create(OrderCreateRequest orderCreateRequest);
    OrderResponseDto findById(Long id);



}
