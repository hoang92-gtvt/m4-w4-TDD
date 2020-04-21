package com.example.portfolio.controller;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Coach;
import com.example.portfolio.service.classes.IClassesService;
import com.example.portfolio.service.coach.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @Autowired
    private ICoachService coachService;

    @GetMapping("/classes")
    public ResponseEntity<Iterable<Classes>> getAllClasses() {
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/classes")
    public ResponseEntity<Classes> createNewClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(classesService.save(classes), HttpStatus.OK);
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<Classes> getClasses(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        return classesOptional.map(classes -> new ResponseEntity<>(classes, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<Classes> updateClassInfo(@PathVariable Long id, @RequestBody Classes classes) {
        Optional<Classes> classesOptional = classesService.findById(id);
        if (!classesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classes.setId(classesOptional.get().getId());
        classesService.save(classes);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<Classes> deleteClass(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        if (!classesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classesService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listClassOfCoach/{coachId}")
    public ResponseEntity<Iterable<Classes>> listClassOfCoach(@PathVariable Long coachId) {
        Optional<Coach> coach = coachService.findById(coachId);
        if (!coach.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Classes> classes = classesService.findAllByCoach(coach.get());
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

}
