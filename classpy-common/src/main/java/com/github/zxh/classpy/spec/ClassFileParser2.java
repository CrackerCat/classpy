package com.github.zxh.classpy.spec;

import com.github.zxh.classpy.common.FileParser;
import com.github.zxh.classpy.common.FilePart;

public class ClassFileParser2 implements FileParser {

    @Override
    public FilePart parse(byte[] data) {
        return new FileParser2(data).parse();
    }

}
