package com.example.moodle.services;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class TestsService {
    public void add(String path, MultipartFile file) throws IOException {
        System.out.println(path);
        if(file != null){
            //create path
            File testDir = new File(path);
            if (!testDir.exists()){
                testDir.mkdirs();
            }
            //create file
            File newFile = new File(path + file.getOriginalFilename());
            newFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
        }else {
            throw new RuntimeException("File is null");
        }
    }

    public void downloadTest(String filePath, HttpServletResponse response) {
        try{
            InputStream is = new FileInputStream(new File(filePath));
            IOUtils.copy(is, response.getOutputStream());
        }catch (IOException e){
            throw new RuntimeException("IOError whiting file");
        }
    }
}
