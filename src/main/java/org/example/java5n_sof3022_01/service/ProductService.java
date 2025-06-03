package org.example.java5n_sof3022_01.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Product;
import org.example.java5n_sof3022_01.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public void saveProduct(@Valid Product product) {

        productRepository.save(product);
    }

    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }
}
