package com.books.user.controller;

import java.io.IOException;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.user.exception.ResourceNotFoundException;
import com.books.user.model.Book;
import com.books.user.model.User;
import com.books.user.repo.BookRepo;
import com.books.user.repo.UserRepo;
import com.books.user.request.RequestBook;
import com.books.user.request.RequestUserAndBook;
import com.books.user.services.BookPDFExporter;
import com.books.user.services.UserServices;
import com.lowagie.text.DocumentException;

@RestController
public class UserAndBookController {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private UserRepo userRepo;

    @Autowired
    private UserServices service;
         
    @GetMapping("/books/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Book> listbook = service.listAll();
         
        BookPDFExporter exporter = new BookPDFExporter(listbook);
        exporter.export(response);
         
    }
	
	
	@PostMapping("/userandbook")
	public ResponseEntity<Map<User, List<Book>>> createUserAndBook(
			@Validated @RequestBody RequestUserAndBook requestUserAndBook) throws ResourceNotFoundException {
		List<Book> listBooks = new ArrayList<Book>();

		User user = userRepo.findById(requestUserAndBook.getUserId()).orElseThrow(
				() -> new ResourceNotFoundException("User not found on :: " + requestUserAndBook.getUserId()));
		for (RequestBook databook : requestUserAndBook.getBooks()) {
			Book entityBooks = new Book();
			entityBooks.setBook_tittle(databook.getBook_tittle());
			entityBooks.setBook_content(databook.getBook_content());
			entityBooks.setUser(user);
			listBooks.add(entityBooks);

		}

		List<Book> saveBook = (List<Book>) bookRepo.saveAll(listBooks);

		Map<User, List<Book>> groupByType = saveBook.stream().collect(Collectors.groupingBy(Book::getUser));

		return ResponseEntity.ok(groupByType);

	}

	@GetMapping("/userandbook/all")
	public Map<User, List<Book>> getAllBook() {
		Iterable<Book> listBook = bookRepo.findAll();
		Map<User, List<Book>> groupByType = ((Collection<Book>) listBook).stream()
				.collect(Collectors.groupingBy(Book::getUser));
		return groupByType;
	}

}
