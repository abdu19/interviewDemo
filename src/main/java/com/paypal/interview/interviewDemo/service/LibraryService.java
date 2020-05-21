package com.paypal.interview.interviewDemo.service;

import com.paypal.interview.interviewDemo.dao.BookRepository;
import com.paypal.interview.interviewDemo.dao.LibraryRepository;
import com.paypal.interview.interviewDemo.exception.BookNotFoundException;
import com.paypal.interview.interviewDemo.exception.LibraryNotFoundException;
import com.paypal.interview.interviewDemo.model.Book;
import com.paypal.interview.interviewDemo.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getLibraryBooks(Long libraryId){
        return bookRepository.findByLibraryId(libraryId);
    }

    public Library getLibrary(Long libraryId){
        return libraryRepository.findById(libraryId)
                .orElseThrow(() -> new LibraryNotFoundException(libraryId));
    }

    public List<Library> getLibraries(){
        return (List<Library>) libraryRepository.findAll();
    }

    public Library createLibrary(Library library){
        return libraryRepository.save(library);
    }

    public Book getBook(Long bookId){
        return bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book, Long id){
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
