package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
  private JdbcClient jdbcClient;

  public BlogRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // 新規投稿を表示するためのリスト(newBlogs)を返す
  public List<Blog> findNewBlogs() {
    return jdbcClient.sql("SELECT * FROM blogs ORDER BY posted_at DESC")
        .query(Blog.class)
        .list();
  }

  // public List<User> findUser(){
  // return jdbcClient.sql("SELECT id, user_name, user_address FROM users")
  // .query(User.class)
  // .list();
  // }

  public Blog getBlogById(Long id) {
    return jdbcClient.sql("SELECT * FROM blogs WHERE id = :id")
        .param("id", id)
        .query(Blog.class)
        .single();
  }

  public void save(BlogForm form) {
    jdbcClient.sql("INSERT INTO blogs (user_name, title, post) VALUES (:user_name, :title, :post)")
        .param("user_name", form.getUser_name())
        .param("title", form.getTitle())
        .param("post", form.getPost())
        .update();
  }
}
