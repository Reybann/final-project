package com.cognizant.mortgagebankingrules.domain.services;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

public interface RuleClassService {
    RuleClass createRuleClass(RuleClass rule);
    RuleClass updateRuleClass(RuleClass rule);
    void removeRuleClass(UUID id);
    RuleClass getRule(UUID id);
}
