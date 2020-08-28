package com.artemis.util;


import java.io.File;

public class Main {

    public static void main(String[] args) {
        String directory = "C:\\Users\\roca12\\Documents\\NetBeansProjects\\Artemis-v0.5\\web\\resources\\imagenes\\index";
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1));
            }
        }
    }
}
