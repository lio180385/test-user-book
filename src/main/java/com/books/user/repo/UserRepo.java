package com.books.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.books.user.model.User;

public interface UserRepo extends CrudRepository<User, Long>{

}
