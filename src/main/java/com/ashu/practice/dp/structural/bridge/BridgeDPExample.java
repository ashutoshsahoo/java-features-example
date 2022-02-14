package com.ashu.practice.dp.structural.bridge;

import java.util.Random;

enum OsType {
    LINUX, WINDOWS, MAC
}

interface FileDownloader {
    Object download();
    boolean store(Object content);
}

interface FileDownloadProvider {
    Object downloadFile();
    boolean storeFile(Object content);
}

public class BridgeDPExample {

    public static void main(String[] args) {
        Random random = new Random();
        OsType[] values = OsType.values();
        int size = values.length;
        OsType os = values[random.nextInt(size)];
        FileDownloadProvider fileDownloadProvider = null;

        switch (os) {
            case LINUX -> fileDownloadProvider = new LinuxFileDownloadProvider();
            case WINDOWS -> fileDownloadProvider = new WindowsFileDownloadProvider();
            case MAC -> fileDownloadProvider = new MacFileDownloadProvider();
        }

        FileDownloader fileDownloader = new FileDownloaderImpl(fileDownloadProvider);
        Object content = fileDownloader.download();
        if (fileDownloader.store(content)) {
            System.out.println("File successfully stored");
        } else {
            System.out.println("File not store");

        }

    }
}

record FileDownloaderImpl(FileDownloadProvider downloadProvider) implements FileDownloader {

    @Override
    public Object download() {
        return downloadProvider.downloadFile();
    }

    @Override
    public boolean store(Object content) {
        return downloadProvider.storeFile(content);
    }
}

class LinuxFileDownloadProvider implements FileDownloadProvider {

    @Override
    public Object downloadFile() {
        return new Object();
    }

    @Override
    public boolean storeFile(Object content) {
        System.out.println("Store file in Linux environment");
        return true;
    }
}


class WindowsFileDownloadProvider implements FileDownloadProvider {

    @Override
    public Object downloadFile() {
        return new Object();
    }

    @Override
    public boolean storeFile(Object content) {
        System.out.println("Store file in Windows environment");
        return true;
    }
}


class MacFileDownloadProvider implements FileDownloadProvider {

    @Override
    public Object downloadFile() {
        return new Object();
    }

    @Override
    public boolean storeFile(Object content) {
        System.out.println("Store file in Mac environment");
        return true;
    }
}