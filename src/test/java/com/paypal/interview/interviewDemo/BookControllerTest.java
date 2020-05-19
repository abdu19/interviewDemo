package com.paypal.interview.interviewDemo;

import com.paypal.interview.interviewDemo.controller.BookController;
import com.paypal.interview.interviewDemo.data.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookControllerTest {
    @Autowired
    BookController bookController;

    @Test
    public void testCreateBook(){
        Book book = new Book();
        book.setName("A");
        book.setAuthor("Author");
        Assertions.assertEquals(book.getAuthor(), bookController.createBook(book).getAuthor());
    }

}
