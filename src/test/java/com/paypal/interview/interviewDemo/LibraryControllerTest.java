package com.paypal.interview.interviewDemo;

import com.paypal.interview.interviewDemo.controller.BookController;
import com.paypal.interview.interviewDemo.controller.LibraryController;
import com.paypal.interview.interviewDemo.model.Book;
import com.paypal.interview.interviewDemo.model.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LibraryControllerTest {
    @Autowired
    LibraryController libraryController;
    @Autowired
    BookController bookController;

    @Test
    public void testGetLibraryBooks(){
        Library library = new Library();
        library.setName("Library 1");
        libraryController.createLibrary(library);

        Book book = new Book();
        book.setName("Book number 1");
        book.setAuthor("Author");
        book.setLibrary(library);
        bookController.createBook(book);

        List<Book> libraryBooks = libraryController.getLibraryBooks(1L);
        Assertions.assertEquals(book.getName(), libraryBooks.get(0).getName());
    }
}
