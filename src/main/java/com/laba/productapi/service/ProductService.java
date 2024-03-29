package com.laba.productapi.service;

import com.laba.productapi.Entity.Product;
import com.laba.productapi.exceptions.ResourceNotFoundException;
import com.laba.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
public Product saveProduct(Product product){

    return productRepository.save(product);
}

    public Product findProductById(Long id){

    return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id + "numaralı ürün bulunamadı"));
    }

    public void delete(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->new ResourceNotFoundException(productId + "numaralı ürün silinemedi"));
        productRepository.delete(product);

    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }




}
