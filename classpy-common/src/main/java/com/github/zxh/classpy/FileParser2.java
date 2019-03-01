package com.github.zxh.classpy;

import com.moandjiezana.toml.Toml;

public class FileParser2 {

    public static void parse() {
        Toml spec = new Toml().read(FileParser2.class.getResourceAsStream("/java_class.toml"));
        System.out.println(spec);
    }

    public static void main(String[] args) {
        parse();
    }

}
