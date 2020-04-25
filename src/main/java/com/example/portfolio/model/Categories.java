package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private OutComes outComes;
}
