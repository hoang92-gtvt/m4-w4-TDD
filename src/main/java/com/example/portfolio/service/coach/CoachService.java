package com.example.portfolio.service.coach;

import com.example.portfolio.model.Coach;
import com.example.portfolio.repository.ICoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachService implements ICoachService {
    @Autowired
    private ICoachRepository coachRepository;

    @Override
    public Iterable<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Optional<Coach> findById(Long id) {
        return coachRepository.findById(id);
    }

    @Override
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public void remove(Long id) {
        coachRepository.deleteById(id);
    }
}
