package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.Rule;

public interface RuleClassService {
    Rule createRuleClass(Rule rule);
    Rule updateRuleClass(String id, String name, int duration, boolean enabled);
    void removeRuleClass(UUID id);
    Rule getRule(UUID id);
}
