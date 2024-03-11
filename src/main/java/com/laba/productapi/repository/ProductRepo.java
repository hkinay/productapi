package com.laba.productapi.repository;

import com.laba.productapi.Entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;


public class ProductRepo {
    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Product> rowMapper=(rs, rowNum) -> new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getString("photoUrl"),
                rs.getString("description"),
                rs.getDouble("price")
        );

    public ProductRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findByCategory(String category){
        String sql ="SELECT * FROM PRODUCTS Where category=?";
        return jdbcTemplate.query(sql, new Object[]{category},rowMapper);
    }

}
