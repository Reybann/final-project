package com.cognizant.mortgagebankingrules;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.mortgagebankingrules.application.controllers.RulesController;
import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.services.RuleDomainService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

@WebMvcTest(RulesController.class)

public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RuleDomainService ruleService;

    @Test
    public void testCreateRule() throws Exception {

        Mockito.doReturn(new Rule(
                UUID.randomUUID(),
                "test",
                true,
                1)).when(ruleService).createRuleClass("name", 1, true);

        mockMvc.perform(post("/rules/createrule").param(
                "name", "name").param("duration", "1").param("enabled", "true"))
                .andExpect(status().isOk());
    }
}
