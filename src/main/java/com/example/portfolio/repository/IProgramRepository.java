package com.example.portfolio.repository;

import com.example.portfolio.model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramRepository extends JpaRepository<Programs, Long> {
}
