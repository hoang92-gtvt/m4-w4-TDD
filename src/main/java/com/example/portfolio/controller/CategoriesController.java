package com.example.portfolio.controller;

import com.example.portfolio.model.Categories;
import com.example.portfolio.model.Skills;
import com.example.portfolio.service.categories.ICategoryService;
import com.example.portfolio.service.skills.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CategoriesController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISkillService skillService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Categories>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Categories> getCategories(@PathVariable Long id){
        Optional<Categories> categories = categoryService.findById(id);
        if (!categories.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories.get(), HttpStatus.OK);
    }
    @PostMapping("/categories")
    public ResponseEntity<Categories> createCategory(@RequestBody Categories categories){
        return new ResponseEntity<>(categoryService.save(categories), HttpStatus.OK);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<Categories> editCategory(@RequestBody Categories categories, @PathVariable Long id){
        Optional<Categories> categoriesOptional = categoryService.findById(id);
        if (!categoriesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categories.setId(id);
        return new ResponseEntity<>(categoryService.save(categories), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Categories> deleteCategory(@PathVariable Long id){
        Optional<Categories> categories = categoryService.findById(id);
        if (!categories.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories/name")
    public ResponseEntity<Categories> findByName(@RequestParam String name){
        Optional<Categories> categories = categoryService.findByName(name);
        if (!categories.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories.get(), HttpStatus.OK);
    }

    @GetMapping("/categories/{id}/skills")
    public ResponseEntity<Iterable<Skills>> findAllByCategories(@PathVariable Long id){
        Optional<Categories> categories = categoryService.findById(id);
        if (!categories.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(skillService.findAllByCategories(categories.get()), HttpStatus.OK);
    }

}
