package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Phone {

    @Id
    @GeneratedValue
    private int id;

    private String phone;

    public Phone(String phone) {
        this.phone = phone;
    }
}
