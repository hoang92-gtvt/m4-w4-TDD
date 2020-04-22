package com.example.portfolio.controller;

import com.example.portfolio.model.Classes;
import com.example.portfolio.model.Student;
import com.example.portfolio.service.classes.IClassesService;
import com.example.portfolio.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassesService classesService;

    @GetMapping("/students")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(studentOptional.get().getId());
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
