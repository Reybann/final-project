package com.cognizant.mortgagebankingrules.application.controllers;

import com.cognizant.mortgagebankingrules.application.response.UpdateRuleResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.mortgagebankingrules.application.response.CreateRuleResponse;
import com.cognizant.mortgagebankingrules.domain.Rule;
import com.cognizant.mortgagebankingrules.domain.dto.RuleClassDto;
import com.cognizant.mortgagebankingrules.application.response.RemoveRuleResponse;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/rules")
public class RulesController {

    @Autowired
    private ModelMapper modelMapper;

    private final RuleClassService ruleClassService;

    @Autowired
    public RulesController(RuleClassService ruleClassService) {
        this.ruleClassService = ruleClassService;
    }

    @PostMapping(value="/createrule")
    public CreateRuleResponse createRule(@RequestBody RuleClassDto ruleClassDto) {
        Rule rule = modelMapper.map(ruleClassDto, Rule.class);
        return new CreateRuleResponse(ruleClassService.createRuleClass(rule));
    }
    @PutMapping(value="/updaterule")
    public UpdateRuleResponse updateRule(@RequestParam String id, @RequestParam String name, @RequestParam int duration, @RequestParam boolean enabled){
        return new UpdateRuleResponse(ruleClassService.updateRuleClass(id, name, duration, enabled));
    }

    @DeleteMapping(value="/removeRule")
    public RemoveRuleResponse deleteRule(@RequestParam UUID id) {
        return new RemoveRuleResponse(ruleClassService.removeRuleClass(id));
    }

}
