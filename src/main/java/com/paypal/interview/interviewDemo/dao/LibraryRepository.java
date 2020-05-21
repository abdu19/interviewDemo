package com.paypal.interview.interviewDemo.dao;

import com.paypal.interview.interviewDemo.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {

}
