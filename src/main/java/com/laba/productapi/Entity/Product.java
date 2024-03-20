package com.laba.productapi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Product {

    //Ödevdeki product özellikleri doğrudan alındı


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String photoUrl;
    private String description;

    private Double price;

    public Product(){}

    public Product(Long id, String name, String category, String photoUrl, String description, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrl = photoUrl;
        this.description = description;
        this.price = price;
    }



    }

