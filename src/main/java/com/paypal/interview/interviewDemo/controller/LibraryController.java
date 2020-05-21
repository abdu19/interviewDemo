package com.paypal.interview.interviewDemo.controller;

import com.paypal.interview.interviewDemo.model.Book;
import com.paypal.interview.interviewDemo.dao.BookRepository;
import com.paypal.interview.interviewDemo.model.Library;
import com.paypal.interview.interviewDemo.dao.LibraryRepository;
import com.paypal.interview.interviewDemo.exception.LibraryNotFoundException;
import com.paypal.interview.interviewDemo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/libraries/{id}")
    public Library getLibrary(Long id){
        return libraryService.getLibrary(id);
    }

    @GetMapping(value = "/libraries/{id}/books")
    public List<Book> getLibraryBooks(Long id){
        return libraryService.getLibraryBooks(id);
    }

    @GetMapping(value = "/libraries")
    public List<Library> getLibraries(){
        return libraryService.getLibraries();
    }

    @PostMapping(value = "/libraries")
    public Library createLibrary(@RequestBody Library library){
        return libraryService.createLibrary(library);
    }

}
