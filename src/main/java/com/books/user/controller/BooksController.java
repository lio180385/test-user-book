package com.books.user.controller;

import java.util.HashMap;
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
import com.books.user.model.Book;
import com.books.user.repo.BookRepo;
import com.books.user.repo.UserRepo;

@RestController
public class BooksController {

	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private UserRepo userRepo;

	/**
	 * Get all Book list.
	 *
	 * @return the list
	 */
	@GetMapping("/books")
	public Iterable<Book> getAllBook() {
		return bookRepo.findAll();
	}

	/**
	 * Create Book Book.
	 *
	 * @param Book the Book
	 * @return the Book
	 */
	@PostMapping("/books")
	public Book createBook(@Validated @RequestBody Book book) {
		System.out.println(book);
		
		return bookRepo.save(book);
	}
	
	
 
	  
	  /**
	   * Gets Book by id.
	   *
	   * @param BookId the Book id
	   * @return the Book by id
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @GetMapping("/book/{id}")
	  public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
	      throws ResourceNotFoundException {
	    Book book =
	        bookRepo
	            .findById(bookId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));
	    return ResponseEntity.ok().body(book);
	  }

	  /**
	   * Update book response entity.
	   *
	   * @param BookId the book id
	   
	   */
	  @PutMapping("/books/{id}")
	  public ResponseEntity<Book> updateBook(
	      @PathVariable(value = "id") Long bookId, @Valid @RequestBody Book bookDetails)
	      throws ResourceNotFoundException {

		  Book book =
	        bookRepo
	            .findById(bookId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));

		  book.setBook_tittle(book.getBook_tittle());
		  book.setBook_content(book.getBook_content());
		  book.setUser(book.getUser());
	    final Book updatedbook = bookRepo.save(book);
	    return ResponseEntity.ok(updatedbook);
	  }

	  /**
	   * Delete user map.
	   *
	   * @param BookId the Book id
	   * @return the map
	   * @throws Exception the exception
	   */
	  @DeleteMapping("/book/{id}")
	  public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId) throws Exception {
		  Book book =
	        bookRepo
	            .findById(bookId )
	            .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));

		  bookRepo.delete(book);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
}
