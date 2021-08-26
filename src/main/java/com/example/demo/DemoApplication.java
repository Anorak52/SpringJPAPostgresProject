package com.example.demo;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {

        Person anna = new Person("Anna", "Andreeva", "Samara");
        Person olesya = new Person("Olesya", "Andreeva", "Moscow");
        Person alex = new Person("Alex", "Andreev", "Omsk");

		Passport passportAnna = new Passport("A11111");
		Passport passportOlesya = new Passport("B22222");

		anna.setPassport(passportAnna);
		olesya.setPassport(passportOlesya);

		List<Person> people = Arrays.asList(anna, olesya, alex);

        personRepository.saveAll(people);
	}
}
