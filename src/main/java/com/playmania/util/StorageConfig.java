package com.playmania.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {
//    @Value("${cloud.aws.credentials.access-key")
//    private String accessKey;
//
//    @Value("${cloud.aws.credentials.secret-key")
//    public String accessSecret;
//    @Value("${cloud.aws.region.static}")
//    public String region;
    AWSCredentials credentials = new BasicAWSCredentials(
            "AKIATCKANEFV6JZY3EEE",
            "KmYYsvaXhBdeNHTk/3JALuIxXN/SGf05NjzqXTAC"
    );

    @Bean
    protected AmazonS3 generateS3Client(){
//        AWSCredentials credentials=new BasicAWSCredentials(accessKey,accessSecret);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();

    }

}
