package com.example.portfolio.controller;

import com.example.portfolio.model.Templates;
import com.example.portfolio.service.template.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class TemplateController {
    @Autowired
    private ITemplateService templateService;

    @GetMapping("/templates")
    public ResponseEntity<Iterable<Templates>> getAllTemplates(){
        return new ResponseEntity<>(templateService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/templates")
    public ResponseEntity<Templates> createTemplate(@RequestBody Templates templates){
        return new ResponseEntity<>(templateService.save(templates), HttpStatus.OK);
    }

    @PutMapping("/templates/{id}")
    public ResponseEntity<Templates> editTemplate(@RequestBody Templates templates, @RequestParam Long id){
        Optional<Templates> optionalTemplates = templateService.findById(id);
        if (!optionalTemplates.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        templates.setId(id);
        templateService.save(templates);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/templates/{id}")
    public ResponseEntity<Templates> getTemplate(@PathVariable Long id){
        Optional<Templates> templatesOptional = templateService.findById(id);
        return templatesOptional.map(templates -> new ResponseEntity<>(templates, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/templates/{id}")
    public ResponseEntity<Templates> deleteTemplate(@PathVariable Long id){
        Optional<Templates> templatesOptional = templateService.findById(id);
        if (!templatesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        templateService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
