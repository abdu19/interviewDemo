package com.paypal.interview.interviewDemo.controller;

import com.paypal.interview.interviewDemo.data.Book;
import com.paypal.interview.interviewDemo.data.BookRepository;
import com.paypal.interview.interviewDemo.data.Library;
import com.paypal.interview.interviewDemo.data.LibraryRepository;
import com.paypal.interview.interviewDemo.exception.LibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/libraries/{id}")
    public Library getLibrary(Long id){
        return libraryRepository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
    }

    @GetMapping(value = "/libraries/{id}/books")
    public List<Book> getLibraryBooks(Long id){
        return bookRepository.findByLibraryId(id);
    }

    @GetMapping(value = "/libraries")
    public List<Library> getLibraries(){
        return (List<Library>) libraryRepository.findAll();
    }

    @PostMapping(value = "/libraries")
    public Library createLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

}
