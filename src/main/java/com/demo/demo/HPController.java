package com.demo.demo;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HPController {
    @GetMapping("/harry-potter")

    public String getName() {
        Faker faker = new Faker();
        String harryPotterCharacter = faker.harryPotter().character();
        return "Harry Potter Character: " + harryPotterCharacter;

    }

}
