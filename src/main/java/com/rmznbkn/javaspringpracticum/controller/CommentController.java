package com.rmznbkn.javaspringpracticum.controller;

import com.rmznbkn.javaspringpracticum.dto.CommentRequestDTO;
import com.rmznbkn.javaspringpracticum.repository.CommentRepository;
import com.rmznbkn.javaspringpracticum.entities.Comment;
import com.rmznbkn.javaspringpracticum.entities.Customer;
import com.rmznbkn.javaspringpracticum.entities.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("product/{id}")
    public ResponseEntity<List<Comment>> getCommentByProductId(@PathVariable Long id){
        Product productEntity=Product.builder().id(id).build();
        List<Comment> commentEntities=commentRepository.findCommentsByProduct(productEntity);
        return ResponseEntity.ok(commentEntities);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<List<Comment>> getCommentByCostumerId(@PathVariable Long id){
        Customer customerEntity=Customer.builder().id(id).build();
        List<Comment> commentEntities=commentRepository.findCommentsByCustomer(customerEntity);
        return ResponseEntity.ok(commentEntities);
    }

    @PostMapping
    public ResponseEntity<List<Comment>> getComments(@RequestBody CommentRequestDTO commentRequest){
        if (Objects.nonNull(commentRequest.getCustomerId())){
            Customer customer=Customer.builder().id(commentRequest.getCustomerId()).build();
            List<Comment> commentEntities=commentRepository.findCommentsByCommentDateGreaterThanEqualAndCommentDateIsLessThanEqualAndCustomer(commentRequest.getStartDate(),commentRequest.getEndDate(),customer);
            return ResponseEntity.ok(commentEntities);
        }

        if(Objects.nonNull((commentRequest.getProductId()))){
            Product product=Product.builder().id(commentRequest.getProductId()).build();
            List<Comment> commentEntities=commentRepository.findCommentsByCommentDateGreaterThanEqualAndCommentDateLessThanEqualAndProduct(commentRequest.getStartDate(),commentRequest.getEndDate(),product);
            return ResponseEntity.ok(commentEntities);
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
