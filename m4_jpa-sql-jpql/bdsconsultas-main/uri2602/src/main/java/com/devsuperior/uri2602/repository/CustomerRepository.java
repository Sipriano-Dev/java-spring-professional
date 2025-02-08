package com.devsuperior.uri2602.repository;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query(nativeQuery = true, value = "SELECT name "
//            + "FROM customers "
//            + "WHERE state= :state ")
//    List<CustomerMinProjection> search1(String state);

    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) " +
            "FROM Customer obj WHERE obj.state= UPPER(:state) ")
    List<CustomerMinDTO> search2(String state);

}
