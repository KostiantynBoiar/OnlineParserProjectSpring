package com.example.onlinewebscrapperspring.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products_scrapper")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductsModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String description;
    private String image;
    private String category;
    private String brand;

}
