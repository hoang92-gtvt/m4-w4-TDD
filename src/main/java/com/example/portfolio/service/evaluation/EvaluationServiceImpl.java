package com.example.portfolio.service.evaluation;

import com.example.portfolio.model.Evaluations;
import com.example.portfolio.repository.IEvaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationServiceImpl implements IEvaluationService {
    @Autowired
    private IEvaluationsRepository repository;

    @Override
    public Iterable<Evaluations> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Evaluations> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Evaluations save(Evaluations evaluations) {
        return repository.save(evaluations);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
