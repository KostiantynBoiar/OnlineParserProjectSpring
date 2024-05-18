package com.scrapper.productmicroservice.Controller;


import com.scrapper.productmicroservice.Model.ProductsModel;
import com.scrapper.productmicroservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
@CrossOrigin
public class ProductsController {
    @Autowired
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/api/v1/products")
    public List<ProductsModel> getProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/api/v1/products/post")
    public void addProduct(@RequestBody ProductsModel product){
        productService.addProduct(product);
    }
    @PutMapping("/api/v1/products/put")
    public void updateProduct(@RequestBody ProductsModel product){
        productService.updateProduct(product);
    }
    @DeleteMapping("/api/v1/products/delete")
    public void deleteProduct(@RequestBody ProductsModel product){
        productService.deleteProduct(product);
    }
    @DeleteMapping("/api/v1/products/all")
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }
    @DeleteMapping("/api/v1/products/delete/id/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
