package com.umbrella.demo.sdk.java.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("/Users/apple/Desktop/demo.txt")) {
            int read = fis.read();
            System.out.println((char)read);
            int i = 0;
            while ((i=fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
