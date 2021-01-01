package com.liff.blog.mapper;

import com.liff.blog.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Select("select * from comment")
    List<Comment> findAllcomment();
    @Select("select * from comment where commentid = #{commentid}")
    Comment findcommentById(int commentid);
    @Select("select * from comment where articleid=#{articleid}")
    Comment findecommentByName(int articleid);
    @Insert("insert into comment(commentid,userid,articleid,fatherid,content,approval,publicationdate)values(#{commentid},#{userid},#{articleid},#{fatherid},#{content},#{approval},#{publicationdate})")
    int addcomment(Comment comment);
    @Delete("delete from comment where commentid=#{commentid}")
    int deletecomment(int commentid);
    @Update("update comment set articleid=#{articleid},userid=#{userid},fatherid=#{fatherid},content=#{content},approval=#{approval},publicationdate=#{publicationdate} where commentid=#{commentid}")
    int updatecomment(Comment comment);
}
