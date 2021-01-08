package com.liff.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fileimg {
    private int fileuuid;
    private int articleid;
//    private int userid;
    private String filename;
    private String path;
    private Date uploadtime;
}
