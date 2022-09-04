package com.example.moodle.controllers;

import com.example.moodle.services.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FilesController {
    private final FileService fileService;
    @Value("${upload.path}")
    private String filePath;

    @PostMapping(value = "/add/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> add(@RequestPart("file") MultipartFile file) throws IOException {
        if(file != null){
            System.out.println("URA: " + filePath + file.getOriginalFilename());
            File newFile = new File(filePath + file.getOriginalFilename());
            newFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
            return ResponseEntity.ok("File was added");
        }
        return ResponseEntity.ok("File is null");
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Void> download(@RequestParam String fileName, HttpServletResponse response){
        System.out.println("file name is: " + fileName);
        try{
            InputStream is = new FileInputStream(new File(filePath + fileName));
            IOUtils.copy(is, response.getOutputStream());
        }catch (IOException e){
            throw new RuntimeException("IOError whiting file");
        }
        return ResponseEntity.ok().build();
    }
}
