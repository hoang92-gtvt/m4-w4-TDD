package com.example.portfolio.service.programs;

import com.example.portfolio.model.Programs;
import com.example.portfolio.repository.IProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgramService implements IProgramsService {
    @Autowired
    private IProgramRepository programRepository;

    @Override
    public Iterable<Programs> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<Programs> findById(Long id) {
        return programRepository.findById(id);
    }

    @Override
    public Programs save(Programs programs) {
        return programRepository.save(programs);
    }

    @Override
    public void remove(Long id) {
        programRepository.deleteById(id);
    }
}
