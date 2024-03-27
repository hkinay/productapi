package com.laba.productapi.repository;

import com.laba.productapi.Entity.Order;
import com.laba.productapi.Entity.OrderItem;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductRepository extends CrudRepository<OrderItem,Long> {


    @Query("Select * From OrderItem po Where po.order.id = : id")
    List<OrderItem> findProductOrdersByOrderId(Long id);

    List<OrderItem> findAllByOrder(Order order);
}
