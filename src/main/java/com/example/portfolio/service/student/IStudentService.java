package com.example.portfolio.service.student;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Student;
import com.example.portfolio.service.GeneralService;

public interface IStudentService extends GeneralService<Student> {
    Iterable<Student> findAllByClasses(Classes classes);
}
