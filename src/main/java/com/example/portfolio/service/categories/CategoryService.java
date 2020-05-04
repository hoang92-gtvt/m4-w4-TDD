package com.example.portfolio.service.categories;

import com.example.portfolio.model.Categories;
import com.example.portfolio.model.Outcomes;
import com.example.portfolio.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Categories> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return categoryRepository.save(categories);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Categories> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Iterable<Categories> findAllByOutComes(Outcomes outcome) {
        return categoryRepository.findAllByOutComes(outcome);
    }
}
