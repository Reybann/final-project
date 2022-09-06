package com.cognizant.mortgagebankingrules.application.request;

import java.util.UUID;

public class UpdateRuleRequest {
    private UUID id;
    private String name;
    private int duration;
    private boolean enabled;

    public UpdateRuleRequest(UUID id, String name, int duration, boolean enabled) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
