package com.umbrella.demo.sdk.java.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BufferedOutputStreamExample {

    public static void main(String[] args) {
        System.out.println("开始接收控制台输入的数据：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("输入的数据为：" + line);
            try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get("/Users/apple/Desktop/demo.txt")))){
                bos.write(line.getBytes(StandardCharsets.UTF_8));
                bos.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();
    }
}
