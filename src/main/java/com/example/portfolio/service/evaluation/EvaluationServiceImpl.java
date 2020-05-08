package com.example.portfolio.service.evaluation;

import com.example.portfolio.model.Coach;
import com.example.portfolio.model.Evaluations;
import com.example.portfolio.model.Templates;
import com.example.portfolio.repository.IEvaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationServiceImpl implements IEvaluationService {
    @Autowired
    private IEvaluationsRepository evaluationsRepository;

    @Override
    public Iterable<Evaluations> findAll() {
        return evaluationsRepository.findAll();
    }

    @Override
    public Optional<Evaluations> findById(Long id) {
        return evaluationsRepository.findById(id);
    }

    @Override
    public Evaluations save(Evaluations evaluations) {
        return evaluationsRepository.save(evaluations);
    }

    @Override
    public void remove(Long id) {
        evaluationsRepository.deleteById(id);
    }

    @Override
    public Iterable<Evaluations> findAllByCoach(Coach coach) {
        return evaluationsRepository.findAllByCoach(coach);
    }

    @Override
    public Iterable<Evaluations> findAllByTemplates(Templates templates) {
        return evaluationsRepository.findAllByTemplates(templates);
    }
}
