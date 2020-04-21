package com.example.portfolio.controller;

import com.example.portfolio.model.Coach;
import com.example.portfolio.service.coach.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/coaches")
    public ResponseEntity<Iterable<Coach>> getAllCoaches() {
        return new ResponseEntity<>(coachService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/coaches")
    public ResponseEntity<Coach> createNewCoach(@RequestBody Coach coach) {
        String defaultPassword = "123456@Abc";
        String encodePassword = passwordEncoder.encode(defaultPassword);
        coach.setPassword(encodePassword);
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
        String email = coachOptional.get().getEmail();
        String password = coachOptional.get().getPassword();
        String coachId = coachOptional.get().getCoachId();
        coach.setId(id);
        coach.setEmail(email);
        coach.setPassword(password);
        coach.setCoachId(coachId);
        coachService.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @DeleteMapping("/coaches/{id}")
    public ResponseEntity<Coach> deleteCoach(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.remove(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
