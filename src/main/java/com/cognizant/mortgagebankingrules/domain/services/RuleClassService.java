package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.Rule;

public interface RuleClassService {
    UUID createRuleClass(String name, int duration, boolean enabled);
    void updateRuleClass(UUID id, String name, int duration, boolean enabled);
    UUID removeRuleClass(UUID id);
    Rule getRule(UUID id);
}
