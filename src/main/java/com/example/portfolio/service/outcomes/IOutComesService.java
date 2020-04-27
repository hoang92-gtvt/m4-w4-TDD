package com.example.portfolio.service.outcomes;

import com.example.portfolio.model.Outcomes;
import com.example.portfolio.service.GeneralService;

import java.util.Optional;

public interface IOutComesService extends GeneralService<Outcomes> {
    Optional<Outcomes> findByTitle(String title);
}
