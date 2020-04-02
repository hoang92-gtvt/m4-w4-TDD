package com.example.portfolio.controller;

import com.example.portfolio.model.Book;
import com.example.portfolio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> showAllBooks() {
        Iterable<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
