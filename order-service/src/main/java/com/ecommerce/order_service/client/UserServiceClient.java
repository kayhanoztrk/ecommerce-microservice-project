package com.ecommerce.order_service.client;

import com.ecommerce.order_service.dto.response.UserResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
@FeignClient(name = "user-service", path="/api/v1/user")
public interface UserServiceClient {
    Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
    @GetMapping("/id/{id}")
    @Retry(name = "findUserByIdRetry", fallbackMethod = "findUserByIdFallback")
    @CircuitBreaker(name = "findUserByIdCircuitBreaker", fallbackMethod = "findUserByIdFallback")
    ResponseEntity<UserResponseDto> findById(@PathVariable Long id);

    default ResponseEntity<UserResponseDto> findUserByIdFallback(Long id, Exception exception){
        logger.info("fallbackMethod is calling!");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new UserResponseDto());
    }
}
