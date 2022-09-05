package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.RuleClass;


public class UpdateRuleResponse {

    private RuleClass rule;

    public UpdateRuleResponse(RuleClass ruleClass) {
        this.rule = ruleClass;
    }

    public RuleClass getRule() {
        return rule;
    }
}
