package com.example.portfolio.service.outcomes;

import com.example.portfolio.model.OutComes;
import com.example.portfolio.repository.IOutcomesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutComesService implements IOutComesService {
    @Autowired
    private IOutcomesRepository outcomesRepository;

    @Override
    public Iterable<OutComes> findAll() {
        return outcomesRepository.findAll();
    }

    @Override
    public Optional<OutComes> findById(Long id) {
        return outcomesRepository.findById(id);
    }

    @Override
    public OutComes save(OutComes outcomes) {
        return outcomesRepository.save(outcomes);
    }

    @Override
    public void remove(Long id) {
        outcomesRepository.deleteById(id);
    }
}
