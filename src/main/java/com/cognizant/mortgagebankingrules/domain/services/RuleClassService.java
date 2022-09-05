package com.cognizant.mortgagebankingrules.domain.services;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

import java.util.UUID;

public interface RuleClassService {
    RuleClass createRuleClass(RuleClass rule);
    RuleClass updateRuleClass(String id, String name, int duration, boolean enabled);
    void removeRuleClass(UUID id);
    RuleClass getRuleClass(String id);
}
