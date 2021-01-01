package com.liff.blog.mapper;

import com.liff.blog.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    @Select("select * from article")
    List<Article> findAllarticle();
    @Select("select * from article where articleid = #{articleid}")
    Article findarticleById(int articleid);
    @Select("select * from article where title=#{title}")
    Article findearticleByTitle(String title);
    @Insert("insert into article(articleid,userid,title,content,approval,label,publicationdate,pp)values(#{articleid},#{userid},#{title},#{content},#{approval},#{label},#{publicationdate},#{pp})")
    int addarticle(Article article);
    @Delete("delete from article where articleid=#{articleid}")
    int deletearticle(int articleid);
    @Update("update article set userid=#{userid},title=#{title},content=#{content},approval=#{approval},label=#{label},publicationdate=#{publicationdate},pp=#{pp} where articleid=#{articleid}")
    int updatearticle(Article article);

}
