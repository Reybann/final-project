package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

import java.util.UUID;

public class GetRuleResponse {

    private final RuleClass rule;

    public GetRuleResponse(RuleClass rule) {
        this.rule = rule;
    }

    public UUID getId() {
        return rule.getId();
    }

    public String getName() {
        return rule.getName();
    }

    public int getDuration() {
        return rule.getDuration();
    }

    public boolean isEnabled() {
        return rule.isEnabled();
    }

}
