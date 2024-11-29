package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.request.ProductCreateRequest;
import com.ecommerce.product_service.dto.response.ProductResponseDto;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProduct(){
        List<ProductResponseDto> productResponseDtoList = productService.findAll();
        return ResponseEntity.ok(productResponseDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id){
        ProductResponseDto productResponseDto = productService.findById(id);
        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductCreateRequest productCreateRequest){
        ProductResponseDto productResponseDto = productService.create(productCreateRequest);
        return ResponseEntity.ok(productResponseDto);
    }
}
