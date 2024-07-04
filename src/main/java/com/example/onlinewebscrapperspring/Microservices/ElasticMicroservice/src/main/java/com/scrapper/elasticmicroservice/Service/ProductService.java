package com.scrapper.elasticmicroservice.Service;

import com.scrapper.elasticmicroservice.Model.ProductModel;
import com.scrapper.elasticmicroservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){
        return (List<ProductModel>) productRepository.findAll();
    }
}
