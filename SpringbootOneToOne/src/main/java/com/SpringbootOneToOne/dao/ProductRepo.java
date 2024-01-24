package com.SpringbootOneToOne.dao;

import org.springframework.data.repository.CrudRepository;

import com.SpringbootOneToOne.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

}
