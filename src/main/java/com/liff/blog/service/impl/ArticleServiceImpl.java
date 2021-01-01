package com.liff.blog.service.impl;

import com.liff.blog.mapper.ArticleMapper;
import com.liff.blog.pojo.Article;
import com.liff.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.findAllarticle();
    }

    @Override
    public Article findArticleById(int articleid) {
        return articleMapper.findarticleById(articleid);
    }

    @Override
    public Article findArticleByTitle(String title) {
        return articleMapper.findearticleByTitle(title);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addarticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updatearticle(article);
    }

    @Override
    public int deleteArticle(int articleid) {
        return articleMapper.deletearticle(articleid);
    }
}
