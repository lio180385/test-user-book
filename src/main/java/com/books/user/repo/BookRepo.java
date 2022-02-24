package com.books.user.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.books.user.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {

	List<Book> findAll(Sort ascending);

}
