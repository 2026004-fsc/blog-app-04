package com.example.blog_app;

public class User {
  private Long id;
  private String user_name;
  private String user_address;

  public User(Long id, String user_name, String user_address){
    this.id = id;
    this.user_name = user_name;
    this.user_address = user_address;
  }

  public Long getId() {
    return id;
  }
  public String getUser_name() {
    return user_name;
  }
  public String getUser_address() {
    return user_address;
  }
}
