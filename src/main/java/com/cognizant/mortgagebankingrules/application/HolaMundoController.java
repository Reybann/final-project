package com.cognizant.mortgagebankingrules.application;

import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @Autowired
    private RuleClassRepository repository;
    @GetMapping("/hello")
    public String sayHello() {
        return String.format("Hello world!");
    }

}
