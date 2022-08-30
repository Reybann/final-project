package com.cognizant.mortgagebankingrules.application.response;

import java.util.UUID;

public class CreateRuleResponse {

    private final UUID id;

    public CreateRuleResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }


}
