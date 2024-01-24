package com.SpringbootOneToOne.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SpringbootOneToOne.dao.ProductRepo;
import com.SpringbootOneToOne.helper.ProductHelper;
import com.SpringbootOneToOne.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo prorepo;
	
	public void save(MultipartFile file) {
		 try {
			List<Product> convertExcelTolist = ProductHelper.convertExcelTolist(file.getInputStream());
			prorepo.saveAll(convertExcelTolist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProduct(){
		return (List<Product>) prorepo.findAll();
		
	}

}
