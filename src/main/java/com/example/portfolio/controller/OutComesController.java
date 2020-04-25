package com.example.portfolio.controller;

import com.example.portfolio.model.OutComes;
import com.example.portfolio.service.outcomes.IOutComesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/outcomes")
    public ResponseEntity<OutComes> createOutComes(@RequestBody OutComes outComes){
        return new ResponseEntity<>(outComesService.save(outComes), HttpStatus.OK);
    }

    @GetMapping("/outcomes/{id}")
    public ResponseEntity<OutComes> getOutComes(@PathVariable Long id){
        Optional<OutComes> optionalOutComes = outComesService.findById(id);
        if (!optionalOutComes.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalOutComes.get(), HttpStatus.OK);
    }

    @DeleteMapping("/outcomes/{id}")
    public ResponseEntity<OutComes> deleteOutComes(@PathVariable Long id){
        Optional<OutComes> optionalOutComes = outComesService.findById(id);
        if (!optionalOutComes.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        outComesService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/outcomes/{id}")
    public ResponseEntity<OutComes> editOutComes(@PathVariable Long id, @RequestBody OutComes outComes){
        Optional<OutComes> optionalOutComes = outComesService.findById(id);
        if (!optionalOutComes.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        outComes.setId(id);
        return new ResponseEntity<>(outComesService.save(outComes), HttpStatus.OK);
    }

}
