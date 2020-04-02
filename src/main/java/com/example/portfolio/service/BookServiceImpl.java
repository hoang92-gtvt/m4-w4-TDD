package com.example.portfolio.service;

import com.example.portfolio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void remove(Long id) {

    }
}
