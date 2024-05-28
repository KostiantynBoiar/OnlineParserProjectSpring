package com.scrapper.productmicroservice.Repository;

import com.scrapper.productmicroservice.Model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductsModel, Long> {
    void deleteById(Long id);
    Optional<ProductsModel> findModelById(Long id);
}
