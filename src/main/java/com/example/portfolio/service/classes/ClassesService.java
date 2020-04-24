package com.example.portfolio.service.classes;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Coach;
import com.example.portfolio.model.Programs;
import com.example.portfolio.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classesRepository.deleteById(id);
    }

    @Override
    public Iterable<Classes> findAllByCoach(Coach coach){
        return classesRepository.findAllByCoach(coach);
    }

    @Override
    public Iterable<Classes> findAllByPrograms(Programs programs){
        return classesRepository.findAllByPrograms(programs);
    }
}
