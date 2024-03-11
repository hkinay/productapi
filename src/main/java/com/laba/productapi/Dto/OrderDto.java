package com.laba.productapi.Dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
    private String musteriid;
    private Date orderDate;
    private List<OrderItemDto> items;

    public String getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(String musteriid) {
        this.musteriid = musteriid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
