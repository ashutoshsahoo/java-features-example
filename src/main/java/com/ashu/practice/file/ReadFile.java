package com.ashu.practice.file;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class ReadFile {
    public static void main(String[] args) {
        final String filePath = "README.md";
        try {
            Path path = Path.of(filePath);
            List<String> textLines = Files.readAllLines(path);
            textLines.forEach(log::info);
            log.info("File Read successful-all lines");
            String text = Files.readString(path);
            log.info("\n {}", text);
        } catch (IOException e) {
            log.error("Error occurred while reading the file", e);
        }
    }
}
