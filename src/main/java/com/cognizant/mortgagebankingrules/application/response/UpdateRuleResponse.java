package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.RuleClass;


public class UpdateRuleResponse {

    private RuleClass rule;

    public UpdateRuleResponse(RuleClass rule) {
        this.rule = rule;
    }

    public RuleClass getRule() {
        return rule;
    }
}
