package com.cognizant.mortgagebankingrules.application.controllers;

import com.cognizant.mortgagebankingrules.application.response.UpdateRuleResponse;

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

import java.util.UUID;


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
    public UpdateRuleResponse updateRule(@RequestParam String id, @RequestParam String name, @RequestParam int duration, @RequestParam boolean enabled){
        return new UpdateRuleResponse(ruleClassService.updateRuleClass(id, name, duration, enabled));
    }

    @GetMapping(value="/getrulebyid")
    public GetRuleResponse findRule(@RequestParam String id){
        return new GetRuleResponse(ruleClassService.getRuleClass(id));
    }

}
