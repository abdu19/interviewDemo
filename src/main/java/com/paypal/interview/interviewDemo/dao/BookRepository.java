package com.paypal.interview.interviewDemo.dao;

import com.paypal.interview.interviewDemo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByLibraryId(Long libraryId);
}
