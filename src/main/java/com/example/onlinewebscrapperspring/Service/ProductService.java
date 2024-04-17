package com.example.onlinewebscrapperspring.Service;

import com.example.onlinewebscrapperspring.Model.ProductsModel;
import com.example.onlinewebscrapperspring.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
