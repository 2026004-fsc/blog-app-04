package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
  private BlogRepository blogRepository;

  public BlogService(BlogRepository blogRepository){
    this.blogRepository = blogRepository;
  }

  public List<Blog> findNewBlogs(){
    return blogRepository.findNewBlogs();
  }

  // public List<User> findUser(){
  //   return blogRepository.findUser();
  // }

  public Blog getBlogById(Long id){
    return blogRepository.getBlogById(id);
  }

  public void save(BlogForm form){
    blogRepository.save(form);
  }
}
