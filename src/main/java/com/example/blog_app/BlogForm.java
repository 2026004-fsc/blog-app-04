package com.example.blog_app;

public class BlogForm {
  private String user_name;
  private String title;
  private String post;
  
  public String getUser_name(){
    return user_name;
  }

  public void setUser_name(String user_name){
    this.user_name = user_name;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public String getPost(){
    return post;
  }

  public void setPost(String post){
    this.post = post;
  }
  
}
