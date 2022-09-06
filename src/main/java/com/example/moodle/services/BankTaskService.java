package com.example.moodle.services;

import com.example.moodle.models.BankTasksModel;
import com.example.moodle.repository.BankTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
public class BankTaskService {
    private final BankTaskRepository bankTaskRepository;

    public void add(String path, MultipartFile file) throws IOException {
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
            bankTaskRepository.save(new BankTasksModel(path + file.getOriginalFilename()));
        }else {
            throw new RuntimeException("File is null");
        }

    }


    public String formingTest(String from, String path, Integer count) throws IOException {
        System.out.println(path);
        List<BankTasksModel> byPath = bankTaskRepository.findBankTasksModelsByPathStartingWith(path);
        System.out.println(byPath.size());
        for(BankTasksModel btm : byPath){
            System.out.println(btm.getPath());
        }
        String zipPath = from + ".zip";
        Pattern p = Pattern.compile( "(\\..+)");
        Matcher m;
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath));
        ZipEntry entry;
        for (int i = 0; i < count; i++) {
            String fileP = byPath.remove((int) (Math.random() * byPath.size()))
                    .getPath();
            m = p.matcher(fileP);

            if(m.find()) {
                System.out.println("" + i + m.group());
                entry = new ZipEntry("" + i + m.group());
                zos.putNextEntry(entry);
                zos.write(
                        Files.readAllBytes(Path.of(fileP)
                        )
                );
            }

        }
        zos.close();
        return zipPath;
    }
}
