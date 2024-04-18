package com.example.onlinewebscrapperspring.Service;

import com.example.onlinewebscrapperspring.Model.ProductsModel;
import com.example.onlinewebscrapperspring.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductsModel getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void addProduct(ProductsModel product) {
        productRepository.save(product);
    }

    public void updateProduct(ProductsModel product) {
        productRepository.save(product);
    }
    public void deleteProduct(ProductsModel product) {
        productRepository.delete(product);
    }
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
