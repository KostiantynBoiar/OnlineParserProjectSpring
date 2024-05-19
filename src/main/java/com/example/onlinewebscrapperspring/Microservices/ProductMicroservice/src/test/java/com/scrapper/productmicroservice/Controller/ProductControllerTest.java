package com.scrapper.productmicroservice.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scrapper.productmicroservice.Model.ProductsModel;
import com.scrapper.productmicroservice.Service.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static java.util.stream.DoubleStream.builder;

@WebMvcTest(controllers = ProductsController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    private ProductsModel productsModel;

    @MockBean
    private ProductService productService;



    @BeforeEach
    public void init(){
        productsModel = ProductsModel.builder()
                .name("Iphone 15 Pro Max")
                .brand("Iphone 15")
                .price(1000)
                .category("Phones")
                .build();

        productsModel = ProductsModel.builder()
                .name("Iphone 14 Pro Max")
                .brand("Iphone 14")
                .price(800)
                .category("Phones")
                .build();
    }


    @Test
    public void ProductControllerTest_GetAllProducts() throws Exception {

    }

}
