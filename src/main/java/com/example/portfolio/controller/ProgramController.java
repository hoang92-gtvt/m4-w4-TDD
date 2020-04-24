package com.example.portfolio.controller;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Programs;
import com.example.portfolio.service.classes.IClassesService;
import com.example.portfolio.service.programs.IProgramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProgramController {
    @Autowired
    private IProgramsService programsService;

    @Autowired
    private IClassesService classesService;

    @GetMapping("/programs")
    public ResponseEntity<Iterable<Programs>> getAllPrograms(){
        return new ResponseEntity<>(programsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/programs")
    public ResponseEntity<Programs> createNewProgram(@RequestBody Programs programs){
        return new ResponseEntity<>(programsService.save(programs), HttpStatus.OK);
    }

    @GetMapping("/programs/name")
    public ResponseEntity<Programs> findByNameProgram(@RequestParam String name){
        Optional<Programs> programsOptional = programsService.findByName(name);
        if(!programsOptional.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(programsOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/programs/{id}")
    public ResponseEntity<Programs> getPrograms(@PathVariable Long id){
        Optional<Programs> optionalPrograms = programsService.findById(id);
        if (!optionalPrograms.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPrograms.get(), HttpStatus.OK);
    }

    @GetMapping("/programs/{id}/classes")
    public ResponseEntity<Iterable<Classes>> findClassByProgram(@PathVariable Long id){
        Optional<Programs> optionalPrograms = programsService.findById(id);
        if (!optionalPrograms.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Classes> classes= classesService.findAllByPrograms(optionalPrograms.get());
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
}
