package com.example.portfolio.service.evaluationdetails;

import com.example.portfolio.model.EvaluationDetails;
import com.example.portfolio.model.Evaluations;
import com.example.portfolio.repository.IEvaluationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationDetailService implements IEvaluationDetailService {
    @Autowired
    private IEvaluationDetailsRepository evaluationDetailsRepository;

    @Override
    public Iterable<EvaluationDetails> findAll() {
        return evaluationDetailsRepository.findAll();
    }

    @Override
    public Optional<EvaluationDetails> findById(Long id) {
        return evaluationDetailsRepository.findById(id);
    }

    @Override
    public EvaluationDetails save(EvaluationDetails evaluationDetails) {
        return evaluationDetailsRepository.save(evaluationDetails);
    }

    @Override
    public void remove(Long id) {
        evaluationDetailsRepository.deleteById(id);
    }

    @Override
    public Iterable<EvaluationDetails> findAllByEvaluation(Evaluations evaluation) {
        return evaluationDetailsRepository.findAllByEvaluations(evaluation);
    }
}
