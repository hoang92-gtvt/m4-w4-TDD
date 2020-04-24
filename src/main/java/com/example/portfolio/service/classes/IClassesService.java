package com.example.portfolio.service.classes;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Coach;
import com.example.portfolio.model.Programs;
import com.example.portfolio.service.GeneralService;

import java.util.List;
import java.util.Optional;

public interface IClassesService extends GeneralService<Classes> {
    Iterable<Classes> findAllByCoach(Coach coach);
    Iterable<Classes> findAllByPrograms(Programs programs);
}
