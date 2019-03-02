package com.github.zxh.classpy;

import com.github.zxh.classpy.common.BytesReader;
import com.github.zxh.classpy.spec.FileSpec;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser2 {

    private final FileSpec spec;
    private final BytesReader reader;

    public FileParser2(byte[] data) {
        spec = new FileSpec("/java_class.toml");
        reader = new BytesReader(data, spec.getByteOrder());
    }

    public void parse() {
        System.out.println(spec);
        System.out.println(spec.getByteOrder());
        System.out.println(spec.getRootNode());
        spec.getRootNode().entrySet().forEach(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });
    }

    public static void main(String[] args) throws Exception {
        URL classURL = FileParser2.class.getResource("/com/github/zxh/classpy/FileParser2.class");
        byte[] classData = Files.readAllBytes(Paths.get(classURL.toURI()));
        System.out.println(classData);
        new FileParser2(classData).parse();
    }

}
