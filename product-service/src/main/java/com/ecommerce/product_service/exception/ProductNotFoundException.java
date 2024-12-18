package com.ecommerce.product_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
