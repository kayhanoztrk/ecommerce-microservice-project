package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.request.ProductCreateRequest;
import com.ecommerce.product_service.dto.response.ProductResponseDto;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface ProductService {
    List<ProductResponseDto> findAll();
    ProductResponseDto findById(Long id);

    ProductResponseDto create(ProductCreateRequest productCreateRequest);
}
