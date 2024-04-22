package com.scrapper.productmicroservice.Controller;


import com.scrapper.productmicroservice.Model.ProductsModel;
import com.scrapper.productmicroservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
public class ProductsController {
    @Autowired
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/api/get")
    public List<ProductsModel> getProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/products/api/post")
    public void addProduct(@RequestBody ProductsModel product){
        productService.addProduct(product);
    }
    @PutMapping("/products/api/put")
    public void updateProduct(@RequestBody ProductsModel product){
        productService.updateProduct(product);
    }
    @DeleteMapping("/products/api/delete")
    public void deleteProduct(@RequestBody ProductsModel product){
        productService.deleteProduct(product);
    }
    @DeleteMapping("/products/api/delete/all")
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }
    @DeleteMapping("/products/api/delete/id")
    public void deleteAllProductsById(@RequestParam Long id){
        productService.deleteProductById(id);
    }
}