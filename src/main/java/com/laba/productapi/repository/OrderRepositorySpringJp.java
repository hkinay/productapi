package com.laba.productapi.repository;

import com.laba.productapi.Entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
@Repository
public interface OrderRepositorySpringJp extends CrudRepository<Order,Long> {
}
