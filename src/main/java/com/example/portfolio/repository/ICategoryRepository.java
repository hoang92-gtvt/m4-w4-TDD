package com.example.portfolio.repository;

import com.example.portfolio.model.Categories;
import com.example.portfolio.model.Outcomes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Categories, Long> {
    Optional<Categories> findByName(String name);
    Iterable<Categories> findAllByOutComes(Outcomes outcome);
}
