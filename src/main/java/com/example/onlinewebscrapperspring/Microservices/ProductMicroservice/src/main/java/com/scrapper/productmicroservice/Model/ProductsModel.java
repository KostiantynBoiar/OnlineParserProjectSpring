package com.scrapper.productmicroservice.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "products_scrapper")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
//@RedisHash("Products")
public class ProductsModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;
    @Column(name = "timestamp")
    private String timestamp;

}
