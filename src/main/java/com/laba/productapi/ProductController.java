package com.laba.productapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
private final ProductService productService;
@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/bycategory")
    public List<Product> getProductsByCategory(@RequestParam String category){
    return productService.getProductsByCategory(category);
}

    @PostMapping({"/save"})
    public ResponseEntity<String> createProduct(@RequestBody Product product){
    productService.saveProduct(product);
    return ResponseEntity.ok("İşleminiz gerçekleşmiştir.");
}

}
