package com.SpringbootOneToOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SpringbootOneToOne.helper.FileUpload;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUpload fileupload;
	
	@PostMapping("file")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		
		try {
		if(file.isEmpty()) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}
		if(!file.getContentType().equals("application/pdf")) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only post pdf");
		}
		//file upload code
		
		boolean fileUpload2 = fileupload.fileUpload(file);
		System.out.println(fileUpload2);
		if(fileUpload2) {
			//return ResponseEntity.ok("File Uploaded Succesfuly");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check all");
	}

}
