package com.cognizant.mortgagebankingrules.application.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;

public class RemoveRuleRequest {

    private UUID id;

    @JsonCreator
    public RemoveRuleRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
