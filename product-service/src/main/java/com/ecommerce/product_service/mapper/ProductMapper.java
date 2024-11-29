package com.ecommerce.product_service.mapper;

import com.ecommerce.product_service.dto.request.ProductCreateRequest;
import com.ecommerce.product_service.dto.response.ProductResponseDto;
import com.ecommerce.product_service.model.Product;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class ProductMapper {

    public Product convertReqToEntity(ProductCreateRequest productCreateRequest){
        Product product = new Product();
        product.setProductName(productCreateRequest.getProductName());
        product.setPrice(productCreateRequest.getPrice());
        return product;
    }

    public ProductResponseDto convertEntityToResp(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setPrice(product.getPrice());
        return productResponseDto;
    }


}
