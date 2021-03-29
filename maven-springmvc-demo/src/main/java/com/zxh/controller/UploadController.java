package com.zxh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        //多文件上传MultipartFile[] file，遍历这个数组
        if (file != null && file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
            //获取文件的名字
            String fileName = file.getOriginalFilename();
            //获取文件的后缀名
            int index = fileName.lastIndexOf(".");
            //UUID这个方法是给文件命名，不重名
            String newFileName = UUID.randomUUID() + fileName.substring(index);
            File NewFile = new File("D:\\upload", newFileName);
            //把上传的文件的内容保写到保存的位置
            file.transferTo(NewFile);
        }
        return "success";

    }
}
