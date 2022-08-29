package com.cognizant.mortgagebankingrules.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RuleClass {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    private void SelectById(Long id){

    }

    public void addRule(){

    }

}
