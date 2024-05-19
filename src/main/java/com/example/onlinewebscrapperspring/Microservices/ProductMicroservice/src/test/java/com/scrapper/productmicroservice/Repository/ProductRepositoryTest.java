package com.scrapper.productmicroservice.Repository;


import com.scrapper.productmicroservice.Model.ProductsModel;
import com.scrapper.productmicroservice.ProductMicroserviceApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void ProductRepository_SaveAll_ReturnSavedProducts() {
        ProductsModel pm = ProductsModel.builder()
                .name("Iphone 15 Pro Max")
                .brand("Iphone 15")
                .price(1000)
                .category("Phones")
                .build();

        ProductsModel productsModel = productRepository.save(pm);

        Assertions.assertNotNull(productsModel);
        Assertions.assertEquals(pm.getName(), productsModel.getName());
        Assertions.assertEquals(pm.getBrand(), productsModel.getBrand());
        Assertions.assertEquals(pm.getPrice(), productsModel.getPrice());
        Assertions.assertEquals(pm.getCategory(), productsModel.getCategory());
    }

    @Test
    public void ProductRepository_DeleteById_ReturnDeletedProduct() {
        ProductsModel pm = ProductsModel.builder()
                .name("Iphone 15 Pro Max")
                .brand("Iphone 15")
                .price(1000)
                .category("Phones")
                .build();

        productRepository.save(pm);
        boolean isDeleted = false;
        try {
            productRepository.deleteById(pm.getId());
            isDeleted = true;
        }catch (Exception e) {
            isDeleted = false;
        }finally {
            Assertions.assertTrue(isDeleted);
        }
    }
}

