package com.umbrella.demo.sdk.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamTest {

    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("/Users/apple/Desktop/demo.txt")) {
            fos.write("dfbsdhjfvasfdahfashjbchjdfs".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
