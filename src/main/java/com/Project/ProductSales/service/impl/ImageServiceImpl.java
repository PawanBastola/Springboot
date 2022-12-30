package com.Project.ProductSales.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Project.ProductSales.Model.Image;

import com.Project.ProductSales.dto.ImageDto;

import com.Project.ProductSales.repo.ImageRepository;
import com.Project.ProductSales.service.ImageService;
import com.Project.ProductSales.utils.FileStorageUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

	// to insert into the tables we need a repository. that here is ImageRepository

	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private FileStorageUtils fileStorageUtils;

	@Override
	public ImageDto saveImage(ImageDto imageDto) throws IOException {

		MultipartFile multipartFile = imageDto.getFile();
		// saving the file to the folders/ servers.

		imageDto.setFile_path_name(fileStorageUtils.storeFile(multipartFile));

		Image image = new Image().builder().id(imageDto.getId()).file_path_name(imageDto.getFile_path_name()).build();
		
		imageRepository.save(image);

		return ImageDto.builder().id(image.getId()).file_path_name(image.getFile_path_name()).build();
	}

	@Override
	public ImageDto findImageById(Integer id) {

		Image image;
		Optional<Image> optionalImage = imageRepository.findById(id);

		if (optionalImage.isPresent()) {
			image = optionalImage.get();
			return ImageDto.builder().id(image.getId()).file_path_name(image.getFile_path_name()).build();
		}
		return null;
	}

	@Override
	public String deleteImage(Integer id) {

		String message = "Not deleted";
		if (imageRepository.findById(id) != null) {
			imageRepository.deleteById(id);
			message = "successfully deleted";
		}

		return message;
	}

	@Override
	public List<ImageDto> getAllImages() {

		List<Image> imageList = imageRepository.findAll();

		return imageList.stream()
				.map(i -> ImageDto.builder().id(i.getId()).file_path_name(i.getFile_path_name()).build())
				.collect(Collectors.toList());

	}

}
