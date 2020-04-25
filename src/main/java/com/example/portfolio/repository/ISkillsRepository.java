package com.example.portfolio.repository;

import com.example.portfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillsRepository extends JpaRepository<Skills, Long> {
}
