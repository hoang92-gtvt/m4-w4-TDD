package com.example.portfolio.service.skills;

import com.example.portfolio.model.Categories;
import com.example.portfolio.model.Skills;
import com.example.portfolio.service.GeneralService;

public interface ISkillService extends GeneralService<Skills> {
    Iterable<Skills> findAllByCategories(Categories category);
}
