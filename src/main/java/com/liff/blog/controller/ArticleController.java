package com.liff.blog.controller;

import com.liff.blog.pojo.Article;
import com.liff.blog.pojo.ArticleCount;
import com.liff.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;



    @RequestMapping(value = "/test")
    @ResponseBody
    public ArticleCount test(){
        ArticleCount articleCount = new ArticleCount();
//        System.out.println(reMap);
        List<Article> articles = articleService.findAll();
        System.out.println(articles.size());

        if(articles.isEmpty()){
            articleCount.setCode(0);
            return articleCount;
        }else {
            articleCount.setCode(1);
            articleCount.setCount(articles.size());
            articleCount.setData(articles);

            return articleCount;
        }
    }

}
