package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
  private BlogRepository blogRepository;

  public BlogService(BlogRepository blogRepository){
    this.blogRepository = blogRepository;
  }

  //新規投稿順に並び替えられたすべてのブログのリストを取得する
  //repositoryのメソッドを実行
  public List<Blog> findNewBlogs(){
    return blogRepository.findNewBlogs();
  }

  //クリックされたブログのデータを取得するrepositoryのメソッドを実行
  public Blog getBlogById(Long id){
    return blogRepository.getBlogById(id);
  }

  //投稿する内容をDBに追加するrepositoryのメソッドを実行
  public void save(BlogForm form){
    blogRepository.save(form);
  }
}
