package com.storyblog.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.storyblog.entities.StoryBlog;

@Service
public interface StroyBlogService {

	StoryBlog saveStoryBlog(StoryBlog stroyBlog);

	List<StoryBlog> getStories();

	String saveFile(String fileName, MultipartFile multipartFile) throws IOException;

}
