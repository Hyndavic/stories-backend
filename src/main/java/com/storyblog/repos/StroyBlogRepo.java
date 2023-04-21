package com.storyblog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storyblog.entities.StoryBlog;

@Repository
public interface StroyBlogRepo extends JpaRepository<StoryBlog, Integer> {

}
