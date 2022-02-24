package com.books.user.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.books.user.model.Book;
import com.books.user.repo.BookRepo;

@Service
@Transactional
public class UserServices {
     
    @Autowired
    private BookRepo repo;
     
    public List<Book> listAll() {
        return repo.findAll(Sort.by("id").ascending());
    }
     
}
