package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
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

  //クリックされたブログのデータ（1レコード）を返す
  public Blog getBlogById(Long id) {
    return jdbcClient.sql("SELECT * FROM blogs WHERE id = :id")
        .param("id", id)
        .query(Blog.class)
        .single();
  }

  //ユーザーが入力した名前、タイトル、本文をDBに追加
  public void save(BlogForm form) {
    jdbcClient.sql("INSERT INTO blogs (user_name, title, post) VALUES (:user_name, :title, :post)")
        .param("user_name", form.getUser_name())
        .param("title", form.getTitle())
        .param("post", form.getPost())
        .update();
  }
}
