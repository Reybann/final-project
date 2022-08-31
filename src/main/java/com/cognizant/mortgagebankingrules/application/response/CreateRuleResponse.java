package com.cognizant.mortgagebankingrules.application.response;


import com.cognizant.mortgagebankingrules.domain.Rule;

public class CreateRuleResponse {

   final  Rule rule;

    public CreateRuleResponse(Rule rule) {
        this.rule = rule;
    }
    
    public Rule getRule() {
        return rule;
    }
}
