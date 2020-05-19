package com.paypal.interview.interviewDemo.controller;

import com.paypal.interview.interviewDemo.data.Book;
import com.paypal.interview.interviewDemo.data.BookRepository;
import com.paypal.interview.interviewDemo.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/books/{id}")
    public Book getBook(Long id){
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping(value = "/books?libraryId=?")
    public @ResponseBody List<Book> getLibraryBooks(Long libraryId){
        return bookRepository.findByLibraryId(libraryId);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PutMapping(value = "/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        return bookRepository.findById(id).map(newBook -> {
            newBook.setAuthor(book.getAuthor());
            newBook.setName(book.getName());
            newBook.setLibrary(book.getLibrary());
            return bookRepository.save(newBook);
        }).orElseGet(()->{
                book.setId(id);
                return bookRepository.save(book);
        });
    }
}
