package com.ecommerce.order_service.client;

import com.ecommerce.order_service.dto.response.ProductResponseDto;
import com.ecommerce.order_service.dto.response.UserResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@FeignClient(name = "product-service", path="/api/v1/product")
public interface ProductServiceClient {
    Logger logger = LoggerFactory.getLogger(ProductServiceClient.class);
    @GetMapping("/id/{id}")
    @CircuitBreaker(name = "findProductByIdCircuitBreaker", fallbackMethod = "findProductByIdFallback")
    ResponseEntity<ProductResponseDto> findById(@PathVariable Long id);

    default ResponseEntity<ProductResponseDto> findProductByIdFallback(Long id, Exception exception){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ProductResponseDto());
    }
}
