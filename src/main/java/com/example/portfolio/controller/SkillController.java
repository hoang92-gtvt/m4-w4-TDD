package com.example.portfolio.controller;

import com.example.portfolio.model.Skills;
import com.example.portfolio.service.skills.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("/skills")
    public ResponseEntity<Iterable<Skills>> getAllSkills(){
        return new ResponseEntity<>(skillService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/skills")
    public ResponseEntity<Skills> createSkill(@RequestBody Skills skills){
        return new ResponseEntity<>(skillService.save(skills), HttpStatus.OK);
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skills> editSkill(@RequestBody Skills skills, @PathVariable Long id){
        Optional<Skills> skillsOptional = skillService.findById(id);
        if (!skillsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        skills.setId(id);
        return new ResponseEntity<>(skillService.save(skills), HttpStatus.OK);
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skills> getSkill(@PathVariable Long id){
        Optional<Skills> skillsOptional = skillService.findById(id);
        if (!skillsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(skillsOptional.get(), HttpStatus.OK);
    }
    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Skills> deleteSkill(@PathVariable Long id){
        Optional<Skills> skillsOptional = skillService.findById(id);
        if (!skillsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        skillService.remove(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }



}
