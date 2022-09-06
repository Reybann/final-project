package com.cognizant.mortgagebankingrules.insfrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cognizant.mortgagebankingrules.Application;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {
        @Bean
        public RuleClassService ruleClassService(final RuleClassRepository repository) {
                return new RuleClassServiceImpl(repository);
        }
}
