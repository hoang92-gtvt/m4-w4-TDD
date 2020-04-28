package com.example.portfolio.repository;

import com.example.portfolio.model.EvaluationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluationDetailsRepository extends JpaRepository<EvaluationDetails, Long> {
}
