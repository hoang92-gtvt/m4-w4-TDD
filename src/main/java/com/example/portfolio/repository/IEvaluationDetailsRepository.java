package com.example.portfolio.repository;

import com.example.portfolio.model.EvaluationDetails;
import com.example.portfolio.model.Evaluations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluationDetailsRepository extends JpaRepository<EvaluationDetails, Long> {
    Iterable<EvaluationDetails> findAllByEvaluations(Evaluations evaluation);
}
