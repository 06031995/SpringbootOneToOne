package com.SpringbootOneToOne.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringbootOneToOne.model.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer>{

	@Query(value="select * from book where book_id=:id",nativeQuery = true)
	Book findBy(int id);

	@Modifying
	@Query(value = "update book set book_name='dfgdsfsd' where book_id=:id",nativeQuery = true)
	int updateById(int id);
	
	
	
	 
}
