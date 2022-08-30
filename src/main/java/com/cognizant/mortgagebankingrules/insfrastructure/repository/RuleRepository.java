package com.cognizant.mortgagebankingrules.insfrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.mortgagebankingrules.domain.Rule;

public interface RuleRepository extends JpaRepository<Rule, UUID> {


}
