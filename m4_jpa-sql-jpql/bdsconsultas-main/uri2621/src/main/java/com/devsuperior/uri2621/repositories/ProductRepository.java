package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(nativeQuery = true, value = "SELECT products.name FROM products " +
//            "INNER JOIN providers " +
//            "ON providers.id = products.id_providers " +
//            "WHERE products.amount BETWEEN :min AND :max " +
//            "AND providers.name LIKE CONCAT(:providersBeginName, '%')")
//    List<ProductMinProjection> seach1 (Integer min, Integer max, String providersBeginName);


    @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount BETWEEN :min AND :max " +
            "AND obj.provider.name LIKE CONCAT(:providersBeginName, '%')")
    List<ProductMinDTO> seach2 (Integer min, Integer max, String providersBeginName);

}
