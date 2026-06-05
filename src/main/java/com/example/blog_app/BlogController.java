package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BlogController {
  private BlogService blogService;

  public BlogController(BlogService blogService){
    this.blogService = blogService;
  }

  @GetMapping("/blogs")
  public String blogs(Model model) {
    List<Blog> newBlogs = blogService.findNewBlogs();
    model.addAttribute("newBlogs", newBlogs);

      return "blog";
  }

  @PostMapping("/blog/{id}/view")
  public String blogView(@PathVariable Long id, Model model) {
      model.addAttribute("id", id);
      
      return "blog-view";
  }
  
  
  
  
}