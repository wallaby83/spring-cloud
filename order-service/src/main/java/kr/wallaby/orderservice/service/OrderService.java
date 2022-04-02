package kr.wallaby.orderservice.service;

import kr.wallaby.orderservice.dto.OrderDto;
import kr.wallaby.orderservice.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetail);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
