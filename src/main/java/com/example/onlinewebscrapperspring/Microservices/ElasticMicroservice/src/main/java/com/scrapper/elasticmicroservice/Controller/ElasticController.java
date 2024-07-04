package com.scrapper.elasticmicroservice.Controller;

import com.scrapper.elasticmicroservice.Model.ProductModel;
import com.scrapper.elasticmicroservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elastic/products/")
public class ElasticController {

        @Autowired
        private ProductService productService;

        @GetMapping("")
        public List<ProductModel> getAllProducts() {
            return productService.getAllProducts();
        }
}
