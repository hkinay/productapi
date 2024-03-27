package com.laba.productapi.service;

import com.laba.productapi.Dto.OrderDto;
import com.laba.productapi.Dto.OrderItemDto;
import com.laba.productapi.Entity.Order;
import com.laba.productapi.Entity.OrderItem;
import com.laba.productapi.Entity.Product;
import com.laba.productapi.repository.OrderRepository;
import com.laba.productapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(orderDto.getMusteriid());
        order.setOrderDate(orderDto.getOrderDate());

        Set<OrderItem> orderItems = new HashSet<>();
        for (OrderItemDto itemDto : orderDto.getItems()) {
            Product product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());
            item.setOrder(order);
            orderItems.add(item);
        }
        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }



}
