package com.cognizant.mortgagebankingrules;

import java.util.Optional;
import java.util.UUID;

import com.cognizant.mortgagebankingrules.domain.RuleClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import com.cognizant.mortgagebankingrules.domain.repositories.RuleClassRepository;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassServiceImpl;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicesTest {

    @Mock
    private RuleClassRepository repository;

    @InjectMocks
    private RuleClassServiceImpl service;

    private RuleClass rule;

    @BeforeEach
    public void setUp() {
        rule = RuleClass.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();
    }

    @MockitoSettings(strictness = Strictness.WARN)
    @Test
    public void givenRule_whenSave_thenReturnRule() {
        given(repository.save(rule)).willReturn(rule);
        given(repository.findById(rule.getId())).willReturn(Optional.empty());

        System.out.println(repository);
        System.out.println(service);
        System.out.println(rule);

        RuleClass savedRule = service.createRuleClass(rule);

        assertThat(savedRule).isNotNull();

    }

    @MockitoSettings(strictness = Strictness.WARN)
    @Test
    public void givenId_whenGet_thenReturnRule() {
        //given
        UUID uid = UUID.randomUUID();
        String idString = String.valueOf(uid);
        RuleClass rule1 = RuleClass.builder().id(uid).name("rule1").enabled(true).duration(3).build();
        given(repository.findById(uid)).willReturn(Optional.ofNullable(rule1));

        System.out.println(repository);
        System.out.println(service);
        System.out.println(rule);

        //when
        RuleClass result = service.getRule(uid);

        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(rule1);

    }

    @MockitoSettings(strictness = Strictness.WARN)
    @Test
    public void givenId_whenGet_thenThrowException() {
        //given
        UUID uid = UUID.randomUUID();
        String idString = String.valueOf(uid);
        RuleClass rule1 = RuleClass.builder().id(uid).name("rule1").enabled(true).duration(3).build();
        given(repository.findById(uid)).willReturn(Optional.empty());

        System.out.println(repository);
        System.out.println(service);
        System.out.println(rule);

        //when                                                   //then
        assertThatThrownBy(() -> service.getRule(uid)).isInstanceOf(IllegalArgumentException.class);

    }

}
