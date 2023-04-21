package com.storyblog.controllers;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storyblog.entities.StoryBlog;
import com.storyblog.services.StroyBlogService;




@RestController
@CrossOrigin
public class StoryBlogController {

	private static final Logger LOG = LogManager.getLogger(StoryBlogController.class.getName());

	
	@Autowired
	StroyBlogService storyBlogService;
	
	
	@PostMapping(path = "/saveStory")
	public ResponseEntity<?> saveorUpdateStory(@RequestPart("story") String story, @RequestPart("file") MultipartFile multipartFile) {
		try {
			StoryBlog stroyBlog = new StoryBlog();
			ObjectMapper objectMapper = new ObjectMapper();
			stroyBlog = objectMapper.readValue(story, StoryBlog.class);
			 LOG.info("[ saveStory method {} ]", stroyBlog);
			 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				long size = multipartFile.getSize();
				
				String fileCode = storyBlogService.saveFile(fileName, multipartFile);
				stroyBlog.setImagepath(fileCode + "-" +fileName);
			return new ResponseEntity<StoryBlog>(storyBlogService.saveStoryBlog(stroyBlog), HttpStatus.OK);
		} catch (Exception e) {
			 LOG.debug("[ saveStory Exception {} ]", e.getMessage());
			 LOG.info("[ error saveStory method {} ]",  e.getMessage());

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping(path = "/updateStory")
	public ResponseEntity<?> updateStory(@RequestBody StoryBlog story) {
		try {
			story.setImageBase64Path("");
			return new ResponseEntity<StoryBlog>(storyBlogService.saveStoryBlog(story), HttpStatus.OK);
		} catch (Exception e) {
			 LOG.debug("[ updateStory Exception {} ]", e.getMessage());

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping(path = "/saveStoryImage")
	public ResponseEntity<?> saveStoryImage(@RequestParam("file") MultipartFile multipartFile) {
		try {
			 LOG.info("[ saveStoryImage method {} ]");
			 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				long size = multipartFile.getSize();
				
				String fileCode = storyBlogService.saveFile(fileName, multipartFile);
			return new ResponseEntity<String>(fileCode, HttpStatus.OK);
		} catch (Exception e) {
			 LOG.debug("[ saveStoryImage Exception {} ]", e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	
	@GetMapping(path = "/getStories")
	public ResponseEntity<?> getStories() {
		try {
			 LOG.info("[ getStories method {} ]");
			return new ResponseEntity<List<StoryBlog>>(storyBlogService.getStories(), HttpStatus.OK);
		} catch (Exception e) {
			 LOG.debug("[ getStories Exception {} ]", e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	

	@PostMapping(path = "/saveStoriesToTest")
	public ResponseEntity<?> saveorUpdateStory(@RequestBody List<StoryBlog> stories) {
		try {
			 LOG.info("[ saveStory method {} ]", stories);
			 stories.forEach(story->{
				 storyBlogService.saveStoryBlog(story);
			 });
			return new ResponseEntity<String>("Created", HttpStatus.OK);
		} catch (Exception e) {
			 LOG.debug("[ saveStory Exception {} ]", e.getMessage());
			 LOG.info("[ error saveStory method {} ]",  e.getMessage());

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	

}
