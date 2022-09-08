package com.rmznbkn.javaspringpracticum.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@Entity(name = "customers")
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50)
    private String name;
    @Size(max = 50)
    private String surname;
    @Size(max = 50)
    private String email;
    @Pattern(regexp = "[0-9\\s]{15}")
    private String phone;
}
