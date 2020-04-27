package com.example.portfolio.service.outcomes;

import com.example.portfolio.model.OutComes;
import com.example.portfolio.service.GeneralService;

import java.util.Optional;

public interface IOutComesService extends GeneralService<OutComes> {
    Optional<OutComes> findByTitle(String title);
}
