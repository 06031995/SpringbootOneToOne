package com.SpringbootOneToOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SpringbootOneToOne.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService proservice;
	
	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file) {
		System.out.println("*********"+file.getOriginalFilename());
		proservice.save(file);
		
	}

}
