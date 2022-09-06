package com.cognizant.mortgagebankingrules.domain.services;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;

@Service
public class RuleClassServiceImpl implements RuleClassService {

    private final RuleClassRepository repository;

    public RuleClassServiceImpl(RuleClassRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public RuleClass createRuleClass(RuleClass rule) {
        return repository.save(rule);
    }

    @Override
    @Transactional
    public RuleClass updateRuleClass(RuleClass rule) {
        final RuleClass updatedRule = repository.findById(rule.getId())
                .orElse(new RuleClass(rule.getId(), rule.getName(), rule.isEnabled(), rule.getDuration()));
        updatedRule.setName(rule.getName());
        updatedRule.setDuration(rule.getDuration());
        updatedRule.setEnabled(rule.isEnabled());
        repository.save(rule);
        return rule;
    }

    @Override
    @Transactional
    public void removeRuleClass(UUID id) {
        repository.removeById(id);
    }

    public RuleClass getRule(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No rule found with id " + id));
    }

}
