package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.request.OrderCreateRequest;
import com.ecommerce.order_service.dto.response.OrderResponseDto;
import com.ecommerce.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> findAllOrderList(){
        List<OrderResponseDto> orderResponseDtoList = orderService.findAll();
        return new ResponseEntity<>(orderResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OrderResponseDto> findById(@PathVariable Long id){
        OrderResponseDto orderResponseDto = orderService.findById(id);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        OrderResponseDto orderResponseDto = orderService.create(orderCreateRequest);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }
}
