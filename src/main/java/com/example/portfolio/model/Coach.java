package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String coachId;

    @Column(nullable = false)
    private String name;
}
