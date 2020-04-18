package com.example.portfolio.controller;

import com.example.portfolio.model.Coach;
import com.example.portfolio.service.coach.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @GetMapping("/coaches")
    public ResponseEntity<Iterable<Coach>> getAllCoaches() {
        return new ResponseEntity<>(coachService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/coaches")
    public ResponseEntity<Coach> createNewCoach(@RequestBody Coach coach) {
        return new ResponseEntity<>(coachService.save(coach), HttpStatus.OK);
    }
}
