package com.SpringbootOneToOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringbootOneToOne.dao.BookRepo;
import com.SpringbootOneToOne.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepo bookrepo;
	

	
	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) bookrepo.findAll();
		return list;
	}


	public Book addBook(Book book) {
		Book save = bookrepo.save(book);
		return save;
	}


	

	public Book getById(int id) {
		Book book =null;
		book=(Book) bookrepo.findBy(id);
		return book;
	}

	@Transactional
	public int updateById(int id) {
		int updateById = bookrepo.updateById(id);
		return updateById;
	}
	
}