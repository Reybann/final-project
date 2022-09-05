package com.cognizant.mortgagebankingrules.application.response;


import com.cognizant.mortgagebankingrules.domain.RuleClass;

public class CreateRuleResponse {

   final  RuleClass rule;

    public CreateRuleResponse(RuleClass rule) {
        this.rule = rule;
    }
    
    public RuleClass getRule() {
        return rule;
    }
}
