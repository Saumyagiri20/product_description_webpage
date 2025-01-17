package com.example.productdescription.service;

import com.example.productdescription.model.Product;
import com.example.productdescription.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
            .map(product -> {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                return productRepository.save(product);
            })
            .orElseGet(() -> {
                updatedProduct.setId(id);
                return productRepository.save(updatedProduct);
            });
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
