package com.github.zxh.classpy.spec;

import com.github.zxh.classpy.common.BytesReader;
import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.spec.Builtin.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser2 {

    private final FileSpec spec;
    private final BytesReader reader;
    private final FilePart root;

    public FileParser2(byte[] data) {
        spec = new FileSpec("/java_class.toml");
        reader = new BytesReader(data, spec.getByteOrder());
        root = new FilePart();
    }

    public void parse() {
        spec.getRootNode().entrySet().forEach(e -> {
            parse(e.getKey(), e.getValue());
        });
    }

    private void parse(String partName, Object partSpec) {
        System.out.println("part: " + partName + ", spec: " + partSpec);
        if (partSpec instanceof String) {
            String partSpecStr = partSpec.toString();
            if (partSpecStr.startsWith("&") && !partSpecStr.contains("[")) {
                if (partSpecStr.equals("&u32")) {
                    Uint32 u32 = new Uint32();
                    u32.read(reader);
                    root.add(partName, u32);
                } else {
                    String referencedSpecName = partSpecStr.substring(1);
                    Object referencedSpec = spec.get(referencedSpecName);
                    parse(partName, referencedSpec);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        URL classURL = FileParser2.class.getResource("/com/github/zxh/classpy/spec/FileParser2.class");
        byte[] classData = Files.readAllBytes(Paths.get(classURL.toURI()));
        new FileParser2(classData).parse();
    }

}
