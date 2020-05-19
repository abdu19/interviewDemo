package com.paypal.interview.interviewDemo.data;

import com.paypal.interview.interviewDemo.data.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByLibraryId(Long libraryId);
}
