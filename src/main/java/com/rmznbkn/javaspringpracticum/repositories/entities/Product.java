package com.rmznbkn.javaspringpracticum.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String price;
    private Date lastUsableDate;
    @OneToMany
    private List<Comment> Comments;

}
