package com.cognizant.mortgagebankingrules.application.controllers;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.application.response.UpdateRuleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.mortgagebankingrules.application.response.CreateRuleResponse;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;


@RestController
@RequestMapping("/rules")
public class RulesController {

    private final RuleClassService ruleClassService;

    @Autowired
    public RulesController(RuleClassService ruleClassService) {
        this.ruleClassService = ruleClassService;
    }

    @PostMapping(value="/createRule")
    public CreateRuleResponse createRule(@RequestParam String name, @RequestParam int duration, @RequestParam boolean enabled) {
        return new CreateRuleResponse(ruleClassService.createRuleClass(name, duration, enabled));
    }
    @PutMapping(value="/updateRule")
    public UpdateRuleResponse updateRule(@RequestParam String id, @RequestParam String name, @RequestParam int duration, @RequestParam boolean enabled){
        return new UpdateRuleResponse(ruleClassService.updateRuleClass(id, name, duration, enabled));
    }

}
