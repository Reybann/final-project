package com.cognizant.mortgagebankingrules;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.mortgagebankingrules.application.controllers.RulesController;
import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

@WebMvcTest(RulesController.class)

public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RuleClassService ruleService;

    @Test
    public void testCreateRule() throws Exception {

        Rule rule = Rule.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(post("/rules/createrule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + rule.getDuration() + "\"}")).andExpect(status().isOk());
    }

    @Test
    public void testCreateRule_fail_badRequest() throws Exception {

        Rule rule = Rule.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(post("/rules/createrule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + "rule.getDuration()" + "\"}")).andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateRule_fail_notFound() throws Exception {

        Rule rule = Rule.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);
        mockMvc.perform(post("/rules/createrules").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + rule.getDuration() + "\"}")).andExpect(status().isNotFound());
    }
}
