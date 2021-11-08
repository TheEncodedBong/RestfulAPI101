package com.teb.practice.restfulapi101.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teb.practice.restfulapi101.bean.Book;
import com.teb.practice.restfulapi101.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String welcomeMessage() {
		return "Hello!";
	}

	@GetMapping("/books")
	public List<Book> getBookList() {
		return bookService.listBooks();
	}

	@GetMapping("/books/{bookId}")
	public Book getBookById(@PathVariable String bookId) {
		Book bookToLookup = bookService.listBookById(bookId);
		return bookToLookup;
	}

	@PostMapping("/books")
	public Book addNewBook(@Valid @RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PatchMapping("/books/{bookId}")
	public Book updateOldBook(@PathVariable String bookId, @RequestBody Book book) {
		Book bookToUpdate = bookService.updateBook(bookId, book);
		return bookToUpdate;
	}

	@DeleteMapping("/books/{bookId}")
	public Book deleteOldBook(@PathVariable String bookId) {
		Book bookToDelete = bookService.removeBook(bookId);
		return bookToDelete;
	}
}
