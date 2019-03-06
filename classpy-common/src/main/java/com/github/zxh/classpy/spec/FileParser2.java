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

    public FilePart parse() {
        spec.getRootNode().entrySet().forEach(e -> {
            parse(e.getKey(), e.getValue(), null);
        });
        return root;
    }

    private void parse(String partName, Object partSpec, String partFormatter) {
        System.out.println("part: " + partName + ", spec: " + partSpec);
        if (partSpec instanceof String) {
            String partSpecStr = partSpec.toString();
            int colonIdx = partSpecStr.indexOf(':');
            if (partFormatter != null) {
                parse(partName, partSpecStr, partFormatter);
            } else if (colonIdx < 0) {
                parse(partName, partSpecStr, null);
            } else {
                parse(partName,
                        partSpecStr.substring(0, colonIdx),
                        partSpecStr.substring(colonIdx + 1));
            }
        }
    }

    private void parse(String partName, String partSpec, String partFormatter) {
        if (partSpec.startsWith("&") && !partSpec.contains("[")) {
            if (partSpec.equals("&u16")) {
                root.add(parseU16(reader, partName, partFormatter));
            } else if (partSpec.equals("&u32")) {
                root.add(parseU32(reader, partName, partFormatter));
            } else {
                String referencedSpecName = partSpec.substring(1);
                Object referencedSpec = spec.get(referencedSpecName);
                parse(partName, referencedSpec, partFormatter);
            }
        }
    }

    private static Uint16 parseU16(BytesReader reader,
                                   String name,
                                   String formatter) {
        Uint16 u16 = new Uint16();
        u16.read(reader);
        u16.setName(name);
        if (formatter != null && !formatter.isEmpty()) {
            u16.setDesc(String.format(formatter, u16.getVal()));
        } else {
            u16.setDesc(u16.getVal().toString());
        }
        return u16;
    }

    private static Uint32 parseU32(BytesReader reader,
                                   String name,
                                   String formatter) {
        Uint32 u32 = new Uint32();
        u32.read(reader);
        u32.setName(name);
        if (formatter != null && !formatter.isEmpty()) {
            u32.setDesc(String.format(formatter, u32.getVal()));
        } else {
            u32.setDesc(u32.getVal().toString());
        }
        return u32;
    }

    public static void main(String[] args) throws Exception {
        URL classURL = FileParser2.class.getResource("/com/github/zxh/classpy/spec/FileParser2.class");
        byte[] classData = Files.readAllBytes(Paths.get(classURL.toURI()));
        new FileParser2(classData).parse();
    }

}
