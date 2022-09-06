package com.cognizant.mortgagebankingrules.domain.services;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;

import java.util.UUID;

public class RuleService {

    private final RuleClassRepository repository;

    public RuleService(RuleClassRepository repository) {
        this.repository = repository;
    }

    public UUID createRule(RuleClass rule) {

        repository.save(rule);
        return rule.getId();

    }

}
