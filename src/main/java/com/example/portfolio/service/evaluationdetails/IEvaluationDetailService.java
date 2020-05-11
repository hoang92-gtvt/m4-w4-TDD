package com.example.portfolio.service.evaluationdetails;

import com.example.portfolio.model.EvaluationDetails;
import com.example.portfolio.model.Evaluations;
import com.example.portfolio.service.GeneralService;

public interface IEvaluationDetailService extends GeneralService<EvaluationDetails> {
    Iterable<EvaluationDetails> findAllByEvaluation(Evaluations evaluation);
}
