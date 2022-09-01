package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
@Service
public class RuleDomainService implements RuleClassService {

    private final RuleClassRepository repository;

    public RuleDomainService(RuleClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rule createRuleClass(String name, int duration, boolean enabled) {
        final Rule rule = new Rule(UUID.randomUUID(), name, enabled, duration);
        repository.save(rule);
        return rule;
    }

    @Override
    public Rule updateRuleClass(String id, String name, int duration, boolean enabled) {
        UUID uid = UUID.fromString(id);
        final Rule rule = repository.findById(uid).orElse(new Rule(uid, name, enabled, duration));
        rule.setName(name);
        rule.setDuration(duration);
        rule.setEnabled(enabled);
        repository.save(rule);
        return rule;
    }

    @Override
    public void removeRuleClass(UUID id) {
        repository.removeById(id);
    }


    public Rule getRule(UUID id) {
       return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No rule found with id " + id));
    }

}
