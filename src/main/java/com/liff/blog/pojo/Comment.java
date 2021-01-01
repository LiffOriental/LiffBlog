package com.liff.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentid;
    private int userid;
    private int articleid;
    private int fatherid;
    private String content;
    private int approval;
    private Date publicationdate;
}
