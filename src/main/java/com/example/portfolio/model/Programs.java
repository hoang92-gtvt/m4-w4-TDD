package com.example.portfolio.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

}

