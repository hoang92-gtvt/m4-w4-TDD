package com.example.portfolio.repository;

import com.example.portfolio.model.OutComes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOutcomesRepository extends JpaRepository<OutComes, Long> {
    Optional<OutComes> findByTitle(String title);
}
