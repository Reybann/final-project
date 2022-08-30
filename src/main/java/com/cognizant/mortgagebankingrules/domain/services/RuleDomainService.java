package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;

public class RuleDomainService implements RuleClassService {

    private final RuleClassRepository repository;

    public RuleDomainService(RuleClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID createRuleClass(String name, int duration, boolean enabled) {
        final Rule rule = new Rule(UUID.randomUUID(), name, enabled, duration);
        repository.save(rule);
        return rule.getId();
    }

    @Override
    public void updateRuleClass(UUID id, String name, int duration, boolean enabled) {
        final Rule rule = repository.findById(id).orElse(new Rule(id, name, enabled, duration));
        rule.setName(name);
        rule.setDuration(duration);
        rule.setEnabled(enabled);
        repository.save(rule);
    }

    @Override
    public void removeRuleClass(UUID id) {
        repository.removeById(id);
    }


    public Rule getRule(UUID id) {
        return repository.findById(id).get();
    }

}
