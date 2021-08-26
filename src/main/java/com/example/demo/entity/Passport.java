package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;

    private String number;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;

    public Passport(String number) {
        this.number = number;
    }
}
