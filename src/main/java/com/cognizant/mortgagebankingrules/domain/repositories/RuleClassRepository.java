package com.cognizant.mortgagebankingrules.domain.repositories;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.RuleClass;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleClassRepository extends JpaRepository<RuleClass,Long> {
    void save(Rule rule);
    Optional<Rule> findById(UUID id);
    void removeById(UUID id);
}
