package com.example.portfolio.controller;

import com.example.portfolio.model.Programs;
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
}
