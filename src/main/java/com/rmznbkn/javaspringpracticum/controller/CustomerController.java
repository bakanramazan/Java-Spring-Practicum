package com.rmznbkn.javaspringpracticum.controller;

import com.rmznbkn.javaspringpracticum.repositories.dao.CustomerRepository;
import com.rmznbkn.javaspringpracticum.repositories.entities.Customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){this.customerRepository=customerRepository;}

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll(){return ResponseEntity.ok(customerRepository.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerRepository.findById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer){
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer " + customer.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomerById(@Valid @RequestBody Customer customer,
                                                     @PathVariable Long id){
        if(!customer.getId().equals(id)){
            throw new IllegalArgumentException(("Id did not match the data"));
        }
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer " + customer.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
        customerRepository.deleteById(id);
        return ResponseEntity.ok("Customer " + id);
    }
}
