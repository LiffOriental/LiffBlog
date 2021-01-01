package com.liff.blog.service;

import com.liff.blog.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();

    public Comment findcommentById(int commentid);

    public Comment findcommentByName(int commentid);

    public int addcomment(Comment comment);

    public int updatecomment(Comment comment);

    public int deletecomment(int commentid);
}
