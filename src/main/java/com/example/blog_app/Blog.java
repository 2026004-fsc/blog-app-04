package com.example.blog_app;

import java.sql.Timestamp;

public class Blog {
  private Long id;
  private String title;
  private String post;
  private String image_path;
  private Timestamp posted_at;
  private Long user_id;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getPost() {
    return post;
  }

  public String getImage_path() {
    return image_path;
  }

  public Timestamp getPosted_at() {
    return posted_at;
  }

  public Long getUser_id() {
    return user_id;
  }
}
