package com.cognizant.mortgagebankingrules;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoryTest {

   @Autowired
    private RuleClassRepository ruleRepository ;
    
    private Rule rule;

    @BeforeEach
    public void setUp() {
        rule =  Rule.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();
    }
    @DisplayName("Test for create rule")
    @Test
    public void givenRule_whenSave_thenReturnRule() {
        
        Rule rule = Rule.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Rule savedRule = ruleRepository.save(rule);

        assertThat(savedRule.getId()).isNotNull();
        assertThat(savedRule.getName()).isEqualTo("rule1");
        assertThat(savedRule.isEnabled()).isTrue();
        assertThat(savedRule.getDuration()).isEqualTo(3);
    }

    @DisplayName("Test find rule")
    @Test
    public void givenRule_whenFind_thenReturnRule(){
        Optional<Rule> foundRule = ruleRepository.findById(rule.getId());
        System.out.println(rule.toString());
        assertThat(foundRule).isNotNull();
    }
    
}
