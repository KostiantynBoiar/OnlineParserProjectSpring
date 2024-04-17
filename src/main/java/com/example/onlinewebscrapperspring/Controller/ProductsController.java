package com.example.onlinewebscrapperspring.Controller;

import com.example.onlinewebscrapperspring.Model.ProductsModel;
import com.example.onlinewebscrapperspring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Controller
public class ProductsController {
    @Autowired
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/get")
    public List<ProductsModel> getProducts(){
        return productService.getAllProducts();
    }
}
