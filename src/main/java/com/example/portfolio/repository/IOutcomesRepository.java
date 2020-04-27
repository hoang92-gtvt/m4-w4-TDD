package com.example.portfolio.repository;

import com.example.portfolio.model.Outcomes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOutcomesRepository extends JpaRepository<Outcomes, Long> {
    Optional<Outcomes> findByTitle(String title);
}
