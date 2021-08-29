package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_person")
    private List<Phone> phones;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAddresses(List<Address> addresses) {
        if (addresses != null){
            addresses.forEach(a->{
                a.setPerson(this);
            });
        }

        this.addresses = addresses;
    }
}
