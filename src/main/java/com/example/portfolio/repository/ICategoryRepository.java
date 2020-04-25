package com.example.portfolio.repository;

import com.example.portfolio.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories, Long> {
}
