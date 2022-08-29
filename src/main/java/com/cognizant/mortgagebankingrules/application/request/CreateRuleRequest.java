package com.cognizant.mortgagebankingrules.application.request;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.sun.istack.NotNull;

import java.util.UUID;

public class CreateRuleRequest {

    @NotNull
    private Rule rule;

    /*@JsonCreator
    public AddProductRequest(@JsonProperty("product") final Product product) {
        this.product = product;
    }*/

    public CreateRuleRequest(){
        Rule rule= new Rule(UUID.randomUUID(),"rule1",true);

        this.rule=rule;
    }

    public Rule getRule() {
        return rule;
    }
}
