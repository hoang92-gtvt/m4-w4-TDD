package com.example.portfolio.controller;

import com.example.portfolio.model.Evaluations;
import com.example.portfolio.service.evaluation.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EvaluationController {
    @Autowired
    private IEvaluationService evaluationService;

    @GetMapping("/evaluations")
    public ResponseEntity<Iterable<Evaluations>> getEvaluations(){
        return new ResponseEntity<>(evaluationService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/evaluations")
    public ResponseEntity<Evaluations> createAvaluation(@RequestBody Evaluations evaluations){
        return new ResponseEntity<>(evaluationService.save(evaluations), HttpStatus.OK);
    }

    @GetMapping("/evaluations/{id}")
    public ResponseEntity<Evaluations> getAvaluation(@PathVariable Long id){
        Optional<Evaluations> evaluations = evaluationService.findById(id);
        if (!evaluations.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evaluations.get(), HttpStatus.OK);
    }

    @PutMapping("/evaluations/{id}")
    public ResponseEntity<Evaluations> editEvaluation(@RequestBody Evaluations evaluations, @PathVariable Long id){
        Optional<Evaluations> evaluationsOptional = evaluationService.findById(id);
        if (!evaluationsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        evaluations.setId(id);
        return new ResponseEntity<>(evaluationService.save(evaluations), HttpStatus.OK);
    }

    @DeleteMapping("/evaluations/{id}")
    public ResponseEntity<Evaluations> deleteEvaluation(@PathVariable Long id){
        Optional<Evaluations> evaluations = evaluationService.findById(id);
        if (!evaluations.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        evaluationService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
