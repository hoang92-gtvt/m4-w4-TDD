package com.example.portfolio.service.evaluation;

import com.example.portfolio.model.Coach;
import com.example.portfolio.model.Evaluations;
import com.example.portfolio.model.Student;
import com.example.portfolio.model.Templates;
import com.example.portfolio.service.GeneralService;

public interface IEvaluationService extends GeneralService<Evaluations> {
    Iterable<Evaluations> findAllByCoach(Coach coach);
    Iterable<Evaluations> findAllByTemplates(Templates templates);
    Iterable<Evaluations> findAllByStudent(Student student);
}
