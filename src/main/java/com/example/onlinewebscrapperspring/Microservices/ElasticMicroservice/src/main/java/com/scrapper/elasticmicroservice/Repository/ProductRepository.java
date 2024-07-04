package com.scrapper.elasticmicroservice.Repository;

import com.scrapper.elasticmicroservice.Model.ProductModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<ProductModel, Long> {

}
