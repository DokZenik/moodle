package com.example.moodle.controllers;

import com.example.moodle.services.BankTaskService;
import com.example.moodle.services.FileService;
import com.example.moodle.services.TestsService;
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
    private final BankTaskService bankTaskService;
    private final TestsService testsService;
    @Value("${upload.free.files.path}")
    private String freeFilePath;

    @Value("${upload.tests.path}")
    private String testsPath;

    @PostMapping(value = "/bank/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> add(@RequestPart String path, @RequestPart("file") MultipartFile file) throws IOException {
        try {
            bankTaskService.add(freeFilePath + path, file);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/test/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addTest(@RequestPart String path, @RequestPart("file") MultipartFile file) throws IOException {
        try {
            testsService.add(testsPath + path, file);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("File was added");
    }

    @GetMapping("/test/download")
    @ResponseBody
    public ResponseEntity<Void> downloadTest(@RequestParam String filePath, HttpServletResponse response){
        filePath = filePath.replace('/','\\');
        System.out.println("file path downloading test is: " + filePath);
        try {
            testsService.downloadTest(filePath, response);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test/forming")
    @ResponseBody
    public ResponseEntity<Void> formTest(@RequestParam String from, @RequestParam String filePath, @RequestParam Integer countTasks, HttpServletResponse response){
        filePath = filePath.replace('/','\\');
        System.out.println(filePath);
        try {
            String path = bankTaskService.formingTest(from, freeFilePath + filePath, countTasks);

            InputStream is = new FileInputStream(new File(path));
            IOUtils.copy(is, response.getOutputStream());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }



    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Void> download(@RequestParam String fileName, HttpServletResponse response){
        System.out.println("file name is: " + fileName);
        try{
            InputStream is = new FileInputStream(new File(freeFilePath + fileName));
            IOUtils.copy(is, response.getOutputStream());
        }catch (IOException e){
            throw new RuntimeException("IOError whiting file");
        }
        return ResponseEntity.ok().build();
    }
}
