package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
  private JdbcClient jdbcClient;

  public BlogRepository(JdbcClient jdbcClient){
    this.jdbcClient = jdbcClient;
  }

  // 新規投稿を表示するためのリスト(newBlogs)を返す
  public List<Blog> findNewBlogs(){
    return jdbcClient.sql("SELECT id, title, post, image_path, posted_at, user_id FROM blogs ORDER BY posted_at DESC")
          .query(Blog.class)
          .list();
    
  }

}
