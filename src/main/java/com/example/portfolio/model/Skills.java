package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String skillId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Categories categories;
}

