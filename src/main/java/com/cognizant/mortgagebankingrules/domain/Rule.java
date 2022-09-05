package com.cognizant.mortgagebankingrules.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
public class Rule {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id ;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @JsonCreator
    public Rule(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
            @JsonProperty("enabled") boolean enabled, @JsonProperty("duration") int duration) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
        this.duration = duration;
    }

}
