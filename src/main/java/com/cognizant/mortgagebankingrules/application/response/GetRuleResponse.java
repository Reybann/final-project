package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.RuleClass;

public class GetRuleResponse {

    private final RuleClass rule;

    public GetRuleResponse(RuleClass rule){
        this.rule = rule;
    }

    public RuleClass getRule() {
        return rule;
    }

}
