package com.cognizant.mortgagebankingrules.domain.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleClassDto {
    private UUID id;
    private String name;
    private int duration;
    private boolean enabled;
}
