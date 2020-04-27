package com.example.portfolio.service.outcomes;

import com.example.portfolio.model.Outcomes;
import com.example.portfolio.repository.IOutcomesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutComesService implements IOutComesService {
    @Autowired
    private IOutcomesRepository outcomesRepository;

    @Override
    public Iterable<Outcomes> findAll() {
        return outcomesRepository.findAll();
    }

    @Override
    public Optional<Outcomes> findById(Long id) {
        return outcomesRepository.findById(id);
    }

    @Override
    public Outcomes save(Outcomes outcomes) {
        return outcomesRepository.save(outcomes);
    }

    @Override
    public void remove(Long id) {
        outcomesRepository.deleteById(id);
    }

    @Override
    public Optional<Outcomes> findByTitle(String title) {
        return outcomesRepository.findByTitle(title);
    }
}
