package com.liff.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int articleid;
    private int userid;
    private String title;
    private String content;
    private int approval;
    private String label;
    private Date publicationdate;
    private int pp;
}
