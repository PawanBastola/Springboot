package com.Project.ProductSales.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ImageDto {

	
	private Integer id;
	
	//for fetching and placing image in Thymeleaf Template.
	private MultipartFile file;


	//for storing the file path and file name;
	private String file_path_name; 
	//the file path and name will be dynamic by declaring the variable in application.properties file.
}
