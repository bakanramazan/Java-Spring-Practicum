package com.rmznbkn.javaspringpracticum.repository;

import com.rmznbkn.javaspringpracticum.entities.Comment;
import com.rmznbkn.javaspringpracticum.entities.Customer;
import com.rmznbkn.javaspringpracticum.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByProduct(Product product);

    List<Comment> findCommentsByCommentDateGreaterThanEqualAndCommentDateLessThanEqualAndProduct(Date commentDate, Date commentDate2, Product product);

    List<Comment> findCommentsByCustomer(Customer customer);

    List<Comment> findCommentsByCommentDateGreaterThanEqualAndCommentDateIsLessThanEqualAndCustomer(Date commentDate, Date commentDate2, Customer customer);
}
