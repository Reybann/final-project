package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.Rule;


public class UpdateRuleResponse {

    private Rule rule;

    public UpdateRuleResponse(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
