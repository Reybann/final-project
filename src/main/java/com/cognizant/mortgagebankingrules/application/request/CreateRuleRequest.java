package com.cognizant.mortgagebankingrules.application.request;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateRuleRequest {
    private String name;
    private int duration;
    private boolean enabled;

    @JsonCreator
    public CreateRuleRequest(String name, int duration, boolean enabled) {
        this.name = name;
        this.duration = duration;
        this.enabled = enabled;
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

    public RuleClass getRule() {
        return null;
    }
    
}
