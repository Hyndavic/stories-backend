package com.storyblog.serviceImpls;

import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.storyblog.entities.StoryBlog;
import com.storyblog.repos.StroyBlogRepo;
import com.storyblog.services.StroyBlogService;

@Service
public class StoryBlogServiceImpl implements StroyBlogService {

	@Autowired
	StroyBlogRepo storyBlogRepo;

	@Override
	public StoryBlog saveStoryBlog(StoryBlog stroyBlog) {
		if (stroyBlog.getId() == 0) {
			stroyBlog.setCreatedDate(LocalDateTime.now());
			stroyBlog.setUpdatedDate(LocalDateTime.now());
			// stroyBlog.setId(getStories().size() + 1);
		} else {
			stroyBlog.setUpdatedDate(LocalDateTime.now());
		}
		return storyBlogRepo.save(stroyBlog);
	}

	@Override
	public List<StoryBlog> getStories() {
		List<StoryBlog> list = storyBlogRepo.findAll();
		list.forEach(story->{
			story.setImageBase64Path(getBase64(story.getImagepath()));
		});
		return list;
	}

	@Override
	public String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadDirectory = Paths.get("generated-images");

		String fileCode = RandomStringUtils.randomAlphanumeric(8);
	
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadDirectory.resolve(fileCode + "-" + fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException ioe) {
			throw new IOException("Error saving uploaded file: " + fileName, ioe);
		}

		return fileCode;
	}

	public String getBase64(String path) {
		byte[] fileContent;
		String encodedString = null;
		try {
			String directoryPath = "generated-images/";
			fileContent = FileUtils.readFileToByteArray(new File(directoryPath + path));
			encodedString = Base64.getEncoder().encodeToString(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encodedString;
	}

}
