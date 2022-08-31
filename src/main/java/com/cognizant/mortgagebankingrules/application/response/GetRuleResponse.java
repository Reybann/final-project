package com.cognizant.mortgagebankingrules.application.response;

import com.cognizant.mortgagebankingrules.domain.Rule;

import java.util.UUID;

public class GetRuleResponse {

    private final Rule rule;

    public GetRuleResponse(Rule rule){
        this.rule = rule;
    }

}
