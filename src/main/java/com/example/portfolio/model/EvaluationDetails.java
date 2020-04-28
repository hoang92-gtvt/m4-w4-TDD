package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class EvaluationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Set<Skills> skills;

    @Column(nullable = false)
    private String evaluation;
}
