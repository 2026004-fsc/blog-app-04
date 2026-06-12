package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

  @GetMapping("/blog/{id}/view")
  public String blogView(@PathVariable Long id, Model model) {
    Blog blog = blogService.getBlogById(id);
    
    model.addAttribute("id", id);
    model.addAttribute("blog", blog);
      
      return "blog-view";
  }
  
  @GetMapping("/blog-post")
  public String blogPost(Model model){
      return "blog-post";
  }

  @PostMapping("/blogs")
  public String blogSave(@ModelAttribute BlogForm form, Model model) {
    blogService.save(form);

    return "redirect:/blogs";
  }
 
}