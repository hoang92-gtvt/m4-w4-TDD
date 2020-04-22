package com.example.portfolio.repository;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByClasses(Classes classes);
}
