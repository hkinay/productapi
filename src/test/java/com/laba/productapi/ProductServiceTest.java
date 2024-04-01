package com.laba.productapi;

import com.laba.productapi.Entity.Product;
import com.laba.productapi.exceptions.ResourceNotFoundException;
import com.laba.productapi.repository.ProductRepository;
import com.laba.productapi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
@InjectMocks
    private ProductService productService;

private Product product;

@BeforeEach
void setUp(){
    product = new Product();
    product.setId(1L);
    product.setName("Test Ürünü");
    product.setCategory("Test Kategori");
    product.setDescription("Test Açıklama");
    product.setPrice(100.0);
    }

    //whenFindProductById_thenReturnProduct: Bu test, bir ürün ID'si verildiğinde, ProductRepository'nin beklenen Product nesnesini döndürdüğünü ve ProductService'in bu nesneyi doğru bir şekilde geri döndürdüğünü kontrol eder.
@Test
    void whenFindProductById_thenReturnProduct(){
    // Arrange
    when(productRepository.findById(1L)).thenReturn(Optional.of(product));
    // Act
    Product foundProduct = productService.findProductById(1L);

    //Assert
    assertNotNull(foundProduct);
    assertEquals(product.getId(), foundProduct.getId());
    assertEquals(product.getName(), foundProduct.getName());
    }
    @Test
    void whenFindProductById_thenThrowResourceNotFoundException(){
    when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class,()->{
        productService.findProductById(2L);
    });
    }
}
