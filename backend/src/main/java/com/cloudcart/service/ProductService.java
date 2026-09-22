package com.cloudcart.service;

import com.cloudcart.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {

        products.add(
            new Product(1L, "Laptop", 65000, "Electronics")
        );

        products.add(
            new Product(2L, "Smartphone", 35000, "Electronics")
        );

        products.add(
            new Product(3L, "Headphones", 5000, "Accessories")
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {

        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product addProduct(Product product) {

        product.setId((long) (products.size() + 1));

        products.add(product);

        return product;
    }
}
