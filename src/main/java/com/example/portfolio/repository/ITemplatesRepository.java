package com.example.portfolio.repository;

import com.example.portfolio.model.Templates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITemplatesRepository extends JpaRepository<Templates, Long> {
}
