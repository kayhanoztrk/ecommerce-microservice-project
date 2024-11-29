package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.request.OrderCreateRequest;
import com.ecommerce.order_service.dto.response.OrderResponseDto;
import com.ecommerce.order_service.model.Order;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class OrderMapper {

    public Order convertReqToEntity(OrderCreateRequest orderCreateRequest){
        Order order = new Order();
        order.setProductId(orderCreateRequest.getProductId());
        order.setUserId(orderCreateRequest.getUserId());
        return order;
    }

   /* public OrderResponseDto convertEntityToResp(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(order.getId());
        orderResponseDto.setUserId(order.getUserId());
        orderResponseDto.setProductIdList(order.getProductId());
        return orderResponseDto;
    }
    */


}
