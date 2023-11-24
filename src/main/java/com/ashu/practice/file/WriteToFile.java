package com.ashu.practice.file;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
public class WriteToFile {

    public static void main(String[] args) {
        Path filePath = Path.of("demo.txt");
        String content = "hello world !!";
        String newContent = "some new data to write";
        try {
            // Creates the file and writes the content
            Files.writeString(filePath, content);
            log.info("File Write successful");

            String text = Files.readString(filePath);
            log.info("File Read successful, content= {}", text);

            // append the text
            Files.writeString(filePath, newContent, StandardOpenOption.APPEND);
            log.info("File write-append successful");

            text = Files.readString(filePath);
            log.info("File Read successful, content= {}", text);


            boolean status = Files.deleteIfExists(filePath);
            log.info("File deletion status={}", status);

        } catch (IOException e) {
            log.error("Error occurred while writing the file", e);
        }
    }
}
