package com.example.portfolio.repository;

import com.example.portfolio.model.OutComes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOutcomesRepository extends JpaRepository<OutComes, Long> {
}
