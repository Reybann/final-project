package com.cognizant.mortgagebankingrules.application.response;


import com.cognizant.mortgagebankingrules.domain.RuleClass;

public class CreateRuleResponse {

   final  RuleClass rule;

    public CreateRuleResponse(RuleClass ruleClass) {
        this.rule = ruleClass;
    }
    
    public RuleClass getRule() {
        return rule;
    }
}
