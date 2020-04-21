package com.example.portfolio.repository;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
    Iterable<Classes> findAllByCoach(Coach coach);
}
