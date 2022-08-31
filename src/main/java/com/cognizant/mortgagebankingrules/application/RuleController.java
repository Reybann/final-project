package com.cognizant.mortgagebankingrules.application;

import com.cognizant.mortgagebankingrules.application.request.CreateRuleRequest;
import com.cognizant.mortgagebankingrules.application.response.CreateRuleResponse;
import com.cognizant.mortgagebankingrules.domain.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class RuleController {

    @GetMapping("/manage-rules")
    public String sayHello() {
        return String.format("Alberto");
    }

    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    CreateRuleResponse createRule(@RequestBody final CreateRuleRequest createRuleRequest) {
        final UUID id = ruleService.createRule(createRuleRequest.getRule());

        return new CreateRuleResponse(id);
    }

}
