package com.liff.blog.controller;

import com.liff.blog.pojo.Fileimg;
import com.liff.blog.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/file")
@ResponseBody
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> fileupload(@RequestParam("file") MultipartFile multipartFile) throws IOException {

//
//        String filename = multipartFile.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        boolean boole = fileService.savefile(multipartFile, uuid);
////        String savePath = "localhost:8080/file/img";
//
//
//        if (boole) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            Map<String, Object> map2 = new HashMap<String, Object>();
//            map.put("code", 0);    //0表示上传成功
//            map.put("msg", "上传成功"); //提示消息
//            //src返回图片上传成功后的下载路径，这里直接给绝对路径
//            map2.put("src", "http://localhost/file/download?uuid=" + uuid);
//            map2.put("title", filename);
//            map.put("data", map2);
//            return map;
//
//        } else {
//            Map<String, Object> map = new HashMap<String, Object>();
//            return map;
//        }
//    }
        //获取旧的文件名
        String oldFilename = multipartFile.getOriginalFilename();
        //获取后缀
        String extension = "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        //生成新的文件名
        String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "") + ".jpg";

        //文件大小
        long size = multipartFile.getSize();

        //文件类型
        String type = multipartFile.getContentType();

        //生成目录
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "static/files";
        System.out.println(realPath);
        String simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = realPath + "/" + simpleDateFormat;
        File dateDir = new File(dateDirPath);
        if (!dateDir.exists())
            dateDir.mkdirs();

        //处理文件上传
        multipartFile.transferTo(new File(dateDir, newFilename));

        //将文件信息放入数据库
        Fileimg fileimg = new Fileimg();
        fileimg.setArticleid(1);
        Date date = new Date();
        fileimg.setUploadtime(date);
        fileimg.setFilename(newFilename);
        fileimg.setPath("/files/" + simpleDateFormat);

        fileService.savefile(fileimg);

        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map.put("code", 0);    //0表示上传成功
        map.put("msg", "上传成功"); //提示消息
        //src返回图片上传成功后的下载路径，这里直接给绝对路径
        map2.put("src", "http://localhost:8080/file/download?filename=" + newFilename);
        map2.put("title", newFilename);
        map.put("data", map2);
        return map;
    }

//
    @RequestMapping("/download")
    private void download(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //数据库查找文件
        Fileimg fileimg = fileService.download(filename);
        //获取文件路径
        String realpath = ResourceUtils.getURL("classpath:").getPath()+"/static"+fileimg.getPath();
        //文件输入流
        FileInputStream fileInputStream = new FileInputStream(new File(realpath,fileimg.getFilename()));
        //响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //传输
        IOUtils.copy(fileInputStream,outputStream);
        //关闭
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);


    }
}
