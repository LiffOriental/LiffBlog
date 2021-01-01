package com.liff.blog.service;

import com.liff.blog.pojo.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findAll();

    public Article findArticleById(int articleid);

    public Article findArticleByTitle(String title);

    public int addArticle(Article article);

    public int updateArticle(Article article);

    public int deleteArticle(int articleid);
    
}
