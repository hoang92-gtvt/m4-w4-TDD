package com.example.portfolio.controller;

import com.example.portfolio.model.OutComes;
import com.example.portfolio.service.outcomes.IOutComesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class OutComesController {
    @Autowired
    private IOutComesService outComesService;

    @GetMapping("/outcomes")
    public ResponseEntity<Iterable<OutComes>> getAllOutComes(){
        Iterable<OutComes> outComes = outComesService.findAll();
        return new ResponseEntity<>(outComes, HttpStatus.OK);
    }
}
