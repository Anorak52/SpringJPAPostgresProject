package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void inverseEndTest() throws Exception {
        List<Person> people = personRepository.findByFirstName("Anna");
        Person anna = people.get(0);

        anna.setLastName("Kuznesova");
        anna.setAddresses(Arrays.asList(new Address("Vologda")));

        personRepository.save(anna);
    }

    @Test
    public void ownerTest() throws Exception {

        List<Address> cities = addressRepository.findByCity("Samara");
        Address samara = cities.get(0);

        samara.setHouseNumber("23");
        samara.setPerson(new Person("Alex", "Semenov"));

        addressRepository.save(samara);

    }
}