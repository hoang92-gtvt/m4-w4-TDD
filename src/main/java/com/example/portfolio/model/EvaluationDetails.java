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

    @ManyToOne
    private Evaluations evaluations;

    @ManyToOne
    private Skills skills;

    @Column(nullable = false)
    private String evaluation;
}
