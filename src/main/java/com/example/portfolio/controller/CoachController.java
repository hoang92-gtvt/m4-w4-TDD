package com.example.portfolio.controller;

import com.example.portfolio.model.Coach;
import com.example.portfolio.service.coach.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @GetMapping("/coaches")
    public ResponseEntity<Iterable<Coach>> getAllCoaches() {
        return new ResponseEntity<>(coachService.findAll(), HttpStatus.OK);
    }
}
