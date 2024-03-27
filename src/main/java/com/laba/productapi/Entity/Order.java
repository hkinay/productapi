package com.laba.productapi.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders") // 'order' SQL'de ayrılmış bir kelime olduğu için 'orders' kullanılabilir
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column (nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date();

    @Column(nullable = false)
    private String orderNumber;


    //orphanRemoval = true özelliği, Order'dan bir OrderItem'ı kaldırdığınızda, bu OrderItem'ın veritabanından da silinmesini sağlar.
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(Long orderid, Date orderDate, String orderNumber, Set<OrderItem> orderItems) {
        this.orderId = orderid;
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;

    }


    public Order() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long id) {
        this.orderId = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String musteriid) {
        this.orderNumber = musteriid;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        item.setOrder(this);
    }

    public void removeOrderItem(OrderItem item) {
        orderItems.remove(item);
        item.setOrder(null);
    }


}


