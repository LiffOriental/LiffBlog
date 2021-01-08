package com.liff.blog.service;

import com.liff.blog.pojo.Fileimg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public interface FileService {


    String IMAGEPATH = "";

    public void savefile(Fileimg fileimg) throws IOException;

    public Fileimg download(String filename);


}
