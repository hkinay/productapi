package com.laba.productapi.controller;

import com.laba.productapi.Dto.OrderDto;
import com.laba.productapi.Entity.Order;
import com.laba.productapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/orders"})
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto){
    Order savedOrder = orderService.createOrder(orderDto);
    if (savedOrder!=null){
        return ResponseEntity.ok("Sipariş başarıyla oluşturuldu");

    }
    else{
        return ResponseEntity.badRequest().body("Sipariş oluşturulamadı");
    }
    }
}
