package com.SpringbootOneToOne.helper;







import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	//static path
	public final String UPLOAD_DIR="D:\\springBoot_workspace\\SpringBootOneToOneMapping\\SpringbootOneToOne\\src\\main\\resources\\static\\images";

	//dinamic path
	//public final String UPLOAD_DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	FileUpload()throws IOException
	{
		
	}

	public boolean fileUpload(MultipartFile multipart) {
		boolean f=false;
		
		try {
			
			InputStream inputStream = multipart.getInputStream();
			byte b[]= new byte[inputStream.available()];
			inputStream.read(b);
			
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipart.getOriginalFilename());
			fos.write(b);
			fos.flush();
			fos.close();
			f=true;
			
			//OR
		//	File.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
