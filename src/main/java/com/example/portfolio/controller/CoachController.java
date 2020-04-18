package com.example.portfolio.controller;

import com.example.portfolio.model.Coach;
import com.example.portfolio.service.coach.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/coaches/{id}")
    public ResponseEntity<Coach> getCoach(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        return coachOptional.map(coach -> new ResponseEntity<>(coach, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/coaches/{id}")
    public ResponseEntity<Coach> updateCoachInfo(@PathVariable Long id, @RequestBody Coach coach) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coach.setId(id);
        coachService.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }
}
