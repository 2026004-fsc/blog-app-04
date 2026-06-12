package com.example.blog_app;

import java.sql.Timestamp;

public class Blog {
  private Long id;    //id
  private String user_name;   //ブログで表示する名前
  private String title;   //ブログタイトル
  private String post;    //ブログの本文
  private String image_path;    //ブログ画像（変更できるようにしたかったが、できなかった
  private Timestamp posted_at;    //投稿日時

  public Long getId() {
    return id;
  }

  public String getUser_name() {
    return user_name;
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

}
