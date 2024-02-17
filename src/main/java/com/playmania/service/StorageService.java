package com.playmania.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class StorageService {

//    @Value("${application.bucket.name}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3Client;
    public String uploadFile(MultipartFile file,String folderName){
        bucketName="playmania";
        File new_file=convertMutliPartFileToFile(file);
        String fileName=folderName+ "/" + System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName,fileName,new_file));
        new_file.delete();

        return generateImageUrl(fileName);
    }
    private byte[] downloadFile(String fileName){
        S3Object s3Object= s3Client.getObject(bucketName,fileName);
        S3ObjectInputStream inputStream=s3Object.getObjectContent();
        try {
            byte[] content=IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public String generateImageUrl(String fileName){
        return "http://"+bucketName+".s3.amazonaws.com/"+fileName;
    }
    public String deleteFile(String fileName){
        s3Client.deleteObject(bucketName,fileName);
        return fileName+" removed ...";
    }
    private File convertMutliPartFileToFile(MultipartFile file){
        File converetedFile =new File(file.getOriginalFilename());
        try(FileOutputStream fos = new FileOutputStream(converetedFile)){
            fos.write(file.getBytes());
        }catch (IOException e){
            log.error(String.valueOf(e));
        }
        return converetedFile;
    }

}
