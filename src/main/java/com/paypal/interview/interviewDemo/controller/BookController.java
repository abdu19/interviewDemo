package com.paypal.interview.interviewDemo.controller;

import com.paypal.interview.interviewDemo.model.Book;
import com.paypal.interview.interviewDemo.dao.BookRepository;
import com.paypal.interview.interviewDemo.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookRepository.class);
    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/books/{id}")
    public Book getBook(Long id){
        logger.info("Book ID: " + id);
        return libraryService.getBook(id);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book){
        return libraryService.createBook(book);
    }

    @PutMapping(value = "/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        return libraryService.updateBook(book, id);
    }
}
