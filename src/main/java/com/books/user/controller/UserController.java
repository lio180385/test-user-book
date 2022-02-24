package com.books.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.user.exception.ResourceNotFoundException;
import com.books.user.model.User;
import com.books.user.repo.UserRepo;
 
/**
 * The type User controller.
 *
 * @author Leo Fadliansyah
 */
@RestController
public class UserController {
	@Autowired
	private UserRepo userRepository;
	/**
	   * Get all users list.
	   *
	   * @return the list
	   */
	
	  @GetMapping("/users")
	  public Iterable<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	  
	  /**
	   * Create user user.
	   *
	   * @param user the user
	   * @return the user
	   */
	  @PostMapping("/users")
	  public User createUser(@Validated @RequestBody User user) {
	    return userRepository.save(user);
	  }
	  
	  /**
	   * Gets users by id.
	   *
	   * @param userId the user id
	   * @return the users by id
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @GetMapping("/users/{id}")
	  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
	      throws ResourceNotFoundException {
	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
	    return ResponseEntity.ok().body(user);
	  }

	  /**
	   * Update user response entity.
	   *
	   * @param userId the user id
	   
	   */
	  @PutMapping("/users/{id}")
	  public ResponseEntity<User> updateUser(
	      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
	      throws ResourceNotFoundException {

	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

	    user.setUsername(userDetails.getUsername());
	   
	    final User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	  }

	  /**
	   * Delete user map.
	   *
	   * @param userId the user id
	   * @return the map
	   * @throws Exception the exception
	   */
	  @DeleteMapping("/user/{id}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

	    userRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
}
