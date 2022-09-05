package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

public interface RuleClassService {
    RuleClass createRuleClass(RuleClass rule);
    RuleClass updateRuleClass(String id, String name, int duration, boolean enabled);
    void removeRuleClass(UUID id);
    RuleClass getRule(UUID id);
}
