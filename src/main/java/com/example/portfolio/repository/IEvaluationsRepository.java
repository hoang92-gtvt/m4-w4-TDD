package com.example.portfolio.repository;

import com.example.portfolio.model.Evaluations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationsRepository extends JpaRepository<Evaluations, Long> {
}
