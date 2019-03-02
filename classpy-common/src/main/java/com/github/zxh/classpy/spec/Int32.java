package com.github.zxh.classpy.spec;

import com.github.zxh.classpy.common.BytesReader;
import com.github.zxh.classpy.common.FilePart;

public class Int32 extends FilePart {

    private int val;

    @Override
    protected void readContent(BytesReader reader) {
        val = reader.readInt();
    }

}
