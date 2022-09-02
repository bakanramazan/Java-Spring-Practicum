package com.rmznbkn.javaspringpracticum.repositories.dao;

import com.rmznbkn.javaspringpracticum.repositories.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByLastUsableDateLessThan(Date currentDate);

    List<Product> findProductsByLastUsableDateGreaterThanOrLastUsableDateIsNull(Date CurrentDate);

}
