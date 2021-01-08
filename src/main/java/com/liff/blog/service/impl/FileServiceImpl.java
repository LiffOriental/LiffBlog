package com.liff.blog.service.impl;

import com.liff.blog.mapper.FileimgMapper;
import com.liff.blog.pojo.Fileimg;
import com.liff.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {


    @Autowired
    private FileimgMapper fileImgMapper;

    @Override
    public void savefile(Fileimg fileimg) {
        fileImgMapper.addfileimg(fileimg);
    }

    @Override
    public Fileimg download(String filename) {
        return fileImgMapper.findfileimgByName(filename);
    }

}
