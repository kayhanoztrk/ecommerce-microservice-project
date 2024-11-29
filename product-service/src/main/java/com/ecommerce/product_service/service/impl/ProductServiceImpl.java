package com.ecommerce.product_service.service.impl;

import com.ecommerce.product_service.dto.request.ProductCreateRequest;
import com.ecommerce.product_service.dto.response.ProductResponseDto;
import com.ecommerce.product_service.exception.ProductNotFoundException;
import com.ecommerce.product_service.mapper.ProductMapper;
import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import com.ecommerce.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        logger.info("product finding all method");
        List<ProductResponseDto> productResponseDtoList = productRepository.findAll()
                .stream()
                .map(product -> mapper.convertEntityToResp(product))
                .collect(Collectors.toList());
        logger.info("found all productList {}", productResponseDtoList);
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id + " product not found!"));
        ProductResponseDto productResponseDto = mapper.convertEntityToResp(product);
        return productResponseDto;
    }

    @Override
    public ProductResponseDto create(ProductCreateRequest productCreateRequest) {
        Product product = mapper.convertReqToEntity(productCreateRequest);
        Product savedProduct = productRepository.save(product);
        return mapper.convertEntityToResp(savedProduct);
    }
}
