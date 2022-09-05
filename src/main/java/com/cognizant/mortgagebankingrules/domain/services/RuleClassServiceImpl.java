package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;

@Service
public class RuleClassServiceImpl implements RuleClassService {

    private final RuleClassRepository repository;

    public RuleClassServiceImpl(RuleClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public RuleClass createRuleClass(RuleClass rule) {
        return repository.save(rule);
    }

    @Override
    public RuleClass updateRuleClass(String id, String name, int duration, boolean enabled) {
        UUID uid = UUID.fromString(id);
        final RuleClass rule = repository.findById(uid).orElse(new RuleClass(uid, name, enabled, duration));
        rule.setName(name);
        rule.setDuration(duration);
        rule.setEnabled(enabled);
        repository.save(rule);
        return rule;
    }

    @Override
    public UUID removeRuleClass(UUID id) {
        repository.removeById(id);
        return id;
    }

    public RuleClass getRule(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No rule found with id " + id));
    }

}
