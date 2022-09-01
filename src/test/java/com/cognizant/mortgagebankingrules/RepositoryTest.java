package com.cognizant.mortgagebankingrules;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.insfrastructure.repository.RuleRepository;

public class RepositoryTest {
   @Autowired
    private RuleRepository ruleRepository;
    
    private Rule rule;

}
