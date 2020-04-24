package com.example.portfolio.service.programs;

import com.example.portfolio.model.Programs;
import com.example.portfolio.service.GeneralService;

import java.util.Optional;

public interface IProgramsService extends GeneralService<Programs> {
    Optional<Programs> findByName(String name);
}
