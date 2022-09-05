package com.cognizant.mortgagebankingrules.insfrastructure.repository;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<RuleClass, UUID> {


}
