package com.cognizant.mortgagebankingrules.infrastrucutre;

import com.cognizant.mortgagebankingrules.Application;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
import com.cognizant.mortgagebankingrules.domain.services.RuleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    RuleService orderService(final RuleClassRepository ruleRepository) {
        return new RuleService(ruleRepository);
    }

}
