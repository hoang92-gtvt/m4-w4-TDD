package com.example.portfolio.repository;

import com.example.portfolio.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoachRepository extends JpaRepository<Coach, Long> {
}
