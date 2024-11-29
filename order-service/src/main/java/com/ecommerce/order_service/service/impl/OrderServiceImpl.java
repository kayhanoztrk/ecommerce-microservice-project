package com.ecommerce.order_service.service.impl;

import com.ecommerce.order_service.client.ProductServiceClient;
import com.ecommerce.order_service.client.UserServiceClient;
import com.ecommerce.order_service.dto.request.OrderCreateRequest;
import com.ecommerce.order_service.dto.response.OrderResponseDto;
import com.ecommerce.order_service.dto.response.ProductResponseDto;
import com.ecommerce.order_service.dto.response.UserResponseDto;
import com.ecommerce.order_service.exception.OrderNotFoundException;
import com.ecommerce.order_service.mapper.OrderMapper;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.repository.OrderRepository;
import com.ecommerce.order_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final ProductServiceClient productServiceClient;
    private final UserServiceClient userServiceClient;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper mapper, ProductServiceClient productServiceClient, UserServiceClient userServiceClient) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.productServiceClient = productServiceClient;
        this.userServiceClient = userServiceClient;
    }

    @Override
    public List<OrderResponseDto> findAll() {
        logger.info("findAll orderList");

        List<OrderResponseDto> orderResponse = orderRepository.findAll()
                .stream()
                .map(order -> {
                    OrderResponseDto orderResponseDto = new OrderResponseDto();
                    UserResponseDto userResponseDto = userServiceClient.findById(order.getUserId()).getBody();
                    List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
                    orderResponseDto.setOrderId(order.getId());
                    orderResponseDto.setUser(userResponseDto);

                    order.getProductId().forEach(productId ->{
                        ProductResponseDto productResponseDto = productServiceClient.findById(productId).getBody();
                        productResponseDtoList.add(productResponseDto);
                    });
                    orderResponseDto.setProductIdList(productResponseDtoList);

                    return orderResponseDto;
                }).collect(Collectors.toList());

        return orderResponse;
    }

    @Override
    public OrderResponseDto create(OrderCreateRequest orderCreateRequest) {
        Order savedOrder = orderRepository.save(mapper.convertReqToEntity(orderCreateRequest));
        return findById(savedOrder.getId());
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        OrderResponseDto orderResponse = orderOptional.stream()
                .map(order ->{
                    OrderResponseDto orderResponseDto = new OrderResponseDto();
                    UserResponseDto userResponseDto = userServiceClient.findById(order.getUserId()).getBody();
                    List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
                    orderResponseDto.setOrderId(order.getId());
                    orderResponseDto.setUser(userResponseDto);

                    order.getProductId().forEach(productId ->{
                        ProductResponseDto productResponseDto = productServiceClient.findById(productId).getBody();
                        productResponseDtoList.add(productResponseDto);
                    });
                    orderResponseDto.setProductIdList(productResponseDtoList);

                    return orderResponseDto;
                }).findFirst()
                .orElseThrow(() -> new OrderNotFoundException(id + " order not found!"));

        return orderResponse;
    }
}