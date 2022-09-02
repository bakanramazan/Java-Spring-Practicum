package com.rmznbkn.javaspringpracticum.repositories.dao;

import com.rmznbkn.javaspringpracticum.repositories.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
