package com.liff.blog.service.impl;

import com.liff.blog.mapper.CommentMapper;
import com.liff.blog.pojo.Comment;
import com.liff.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAllcomment();
    }

    @Override
    public Comment findcommentById(int commentid) {
        return commentMapper.findcommentById(commentid);
    }

    @Override
    public Comment findcommentByName(int commentid) {
        return commentMapper.findcommentById(commentid);
    }

    @Override
    public int addcomment(Comment comment) {
        return commentMapper.addcomment(comment);
    }

    @Override
    public int updatecomment(Comment comment) {
        return commentMapper.updatecomment(comment);
    }

    @Override
    public int deletecomment(int commentid) {
        return commentMapper.deletecomment(commentid);
    }
}
