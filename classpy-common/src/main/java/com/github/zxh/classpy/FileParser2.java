package com.github.zxh.classpy;

import com.github.zxh.classpy.spec.FileSpec;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser2 {

    public static void parse(byte[] data) {
        FileSpec spec = new FileSpec("/java_class.toml");

        System.out.println(spec);
        System.out.println(spec.getByteOrder());
//        System.out.println(spec.getTable());
    }

    public static void main(String[] args) throws Exception {
        URL classURL = FileParser2.class.getResource("/com/github/zxh/classpy/FileParser2.class");
        byte[] classData = Files.readAllBytes(Paths.get(classURL.toURI()));
        System.out.println(classData);
        parse(classData);
    }

}
