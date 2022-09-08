package com.rmznbkn.javaspringpracticum.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 500)
    private String comment;
    private Date commentDate;
    @OneToOne
    private Product product;
    @OneToOne
    private Customer customer;
}
