package com.cognizant.mortgagebankingrules.application.response;

import java.util.UUID;

public class RemoveRuleResponse {

    private final UUID id;

    public RemoveRuleResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
