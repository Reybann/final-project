package com.cognizant.mortgagebankingrules.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/hello")
    public String sayHello() {
        return String.format("Hello moto!");
    }

}
