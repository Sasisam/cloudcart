package com.cloudcart;

import com.cloudcart.model.Product;
import com.cloudcart.service.ProductService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void shouldReturnProducts() {

        ProductService productService = new ProductService();

        List<Product> products = productService.getAllProducts();

        assertNotNull(products);

        assertEquals(3, products.size());
    }

    @Test
    void shouldFindProductById() {

        ProductService productService = new ProductService();

        Product product = productService.getProductById(1L);

        assertNotNull(product);

        assertEquals("Laptop", product.getName());
    }

    @Test
    void shouldReturnNullForUnknownProduct() {

        ProductService productService = new ProductService();

        Product product = productService.getProductById(100L);

        assertNull(product);
    }
}
