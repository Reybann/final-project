package com.cognizant.mortgagebankingrules;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.mortgagebankingrules.application.controllers.RulesController;
import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(post("/rules/createrule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + rule.getDuration() + "\"}")).andExpect(status().isOk());
    }

    @Test
    public void testCreateRule_fail_badRequest() throws Exception {

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(post("/rules/createrule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + "rule.getDuration()" + "\"}")).andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateRule_fail_notFound() throws Exception {

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule1").enabled(true).duration(3).build();

        Mockito.when(ruleService.createRuleClass(rule)).thenReturn(rule);
        mockMvc.perform(post("/rules/createrules").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + rule.getName() + "\",\"enabled\":\"" + rule.isEnabled()
                        + "\",\"duration\":\"" + rule.getDuration() + "\"}")).andExpect(status().isNotFound());
    }
    @Test
    public void testUpdateRule() throws Exception {

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule2").enabled(true).duration(6).build();

        Mockito.when(ruleService.updateRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(put("/rules/updaterule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + "rul3" + "\",\"enabled\":\"" + false
                        + "\",\"duration\":\"" + 2 + "\"}")).andExpect(status().isOk());
    }

    @Test
    public void testUpdateRule_fail_badRequest() throws Exception {

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule3").enabled(false).duration(65).build();

        Mockito.when(ruleService.updateRuleClass(rule)).thenReturn(rule);

        mockMvc.perform(post("/rules/createrule").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + "rule.getName()" + "\",\"enabled\":\"" + "rule.isEnabled()"
                        + "\",\"duration\":\"" + "rule.getDuration()" + "\"}")).andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateRule_fail_notFound() throws Exception {

        RuleClass rule = RuleClass.builder().id(UUID.randomUUID()).name("rule4").enabled(true).duration(2).build();

        Mockito.when(ruleService.updateRuleClass(rule)).thenReturn(rule);
        mockMvc.perform(post("/rules/update").contentType("application/json").content(
                "{\"id\":\"" + rule.getId() + "\",\"name\":\"" + "ruel" + "\",\"enabled\":\"" + false
                        + "\",\"duration\":\"" + 5 + "\"}")).andExpect(status().isNotFound());
    }
}
