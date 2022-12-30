package com.Project.ProductSales.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileStorageUtils {

	
	@Value("${image.directory}")
	private String imageStorageDirectory;
	
	private String userHome = System.getProperty("user.home");//returns home/pawan of local device.

	//takes multipart file , saves and return file path.i.e string.
	public String storeFile(MultipartFile multipartFile) throws IOException {
		
		
		String fileStorageLocation = userHome + imageStorageDirectory;
		
		File directoryFile = new File(fileStorageLocation);
		//checking if the file location exists or not
		if(!directoryFile.exists()) {
			directoryFile.mkdirs(); // note: mkdirs() return type is boolean
		}else {
			System.out.println("yes the directory exists");
		}
		
//		String fileNameToSave = fileStorageLocation + multipartFile.getOriginalFilename(); // file ko name eutei vayo vane save hudeina 
		String fileNameToSave = fileStorageLocation + File.separator+ UUID.randomUUID() + "_" + multipartFile.getOriginalFilename(); //so we use uuid for random string generation.
		
		File fileToSave = new File(fileNameToSave);
		multipartFile.transferTo(fileToSave);
		
		return fileNameToSave;
	}
}
