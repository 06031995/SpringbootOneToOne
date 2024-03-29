package com.SpringbootOneToOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringbootOneToOne.model.Book;
import com.SpringbootOneToOne.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity <List<Book>> getAllBook(){
		List<Book> allBook = bookService.getAllBook();
		System.out.println(allBook);
		if(allBook.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(allBook);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		System.out.println(book);
		Book book1= new Book();
		book1=bookService.addBook(book);
		return book1;
	}
	
	@GetMapping("/book/{id}")
	public Book getById(@PathVariable("id") int id) {
		Book book=bookService.getById(id);
		return book;
	}
	
	@PutMapping("/book/{id}")
	public int updateByid(@PathVariable("id") int id) {
		int i=bookService.updateById(id);
		return i;
	}
   
}
