package com.example.portfolio.controller;

import com.example.portfolio.model.Programs;
import com.example.portfolio.service.programs.IProgramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ProgramController {
    @Autowired
    private IProgramsService programsService;

    @GetMapping("/programs")
    public ResponseEntity<Iterable<Programs>> getAllPrograms(){
        return new ResponseEntity<>(programsService.findAll(), HttpStatus.OK);
    }
}
