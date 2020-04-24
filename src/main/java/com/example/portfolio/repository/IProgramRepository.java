package com.example.portfolio.repository;

import com.example.portfolio.model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProgramRepository extends JpaRepository<Programs, Long> {
    Optional<Programs> findByName(String name);
}
