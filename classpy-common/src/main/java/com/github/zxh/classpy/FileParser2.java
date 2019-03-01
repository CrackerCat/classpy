package com.github.zxh.classpy;

import com.moandjiezana.toml.Toml;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser2 {

    public static void parse(byte[] data) {
        Toml spec = new Toml().read(FileParser2.class.getResourceAsStream("/java_class.toml"));
        System.out.println(spec);
        System.out.println(spec.getString("endianness"));
        System.out.println(spec.getString("root_node"));
    }

    public static void main(String[] args) throws Exception {
        URL classURL = FileParser2.class.getResource("/com/github/zxh/classpy/FileParser2.class");
        byte[] classData = Files.readAllBytes(Paths.get(classURL.toURI()));
        System.out.println(classData);
        parse(classData);
    }

}
