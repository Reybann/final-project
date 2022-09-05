package com.cognizant.mortgagebankingrules.application.controllers;

import java.util.UUID;

import com.cognizant.mortgagebankingrules.application.response.GetRuleResponse;
import com.cognizant.mortgagebankingrules.application.response.UpdateRuleResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.mortgagebankingrules.application.response.CreateRuleResponse;
import com.cognizant.mortgagebankingrules.domain.RuleClass;
import com.cognizant.mortgagebankingrules.domain.dto.RuleClassDto;
import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;
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
        RuleClass rule = modelMapper.map(ruleClassDto, RuleClass.class);
        return new CreateRuleResponse(ruleClassService.createRuleClass(rule));
    }
    @PutMapping(value="/updaterule")
    public UpdateRuleResponse updateRule(@RequestBody RuleClassDto ruleClassDto){
        RuleClass rule = modelMapper.map(ruleClassDto, RuleClass.class);
        return new UpdateRuleResponse(ruleClassService.updateRuleClass(rule));
    }

    @GetMapping(value = "/getrule")
    public RuleClass getRule(@RequestBody RuleClassDto ruleClassDto) {
        return ruleClassService.getRule(ruleClassDto.getId());
    }

    @GetMapping(value="/getRuleById")
    public GetRuleResponse ruleResponse(@RequestParam UUID id){
        System.out.println("GetRuleResponse");
        return new GetRuleResponse(ruleClassService.getRule(id));
    }

}
