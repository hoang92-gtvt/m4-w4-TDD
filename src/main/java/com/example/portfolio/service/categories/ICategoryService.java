package com.example.portfolio.service.categories;

import com.example.portfolio.model.Categories;
import com.example.portfolio.service.GeneralService;

import java.util.Optional;

public interface ICategoryService extends GeneralService<Categories> {
    Optional<Categories> findByName(String name);
}
