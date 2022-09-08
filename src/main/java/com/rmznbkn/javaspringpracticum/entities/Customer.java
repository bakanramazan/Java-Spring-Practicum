package com.rmznbkn.javaspringpracticum.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity(name="customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
