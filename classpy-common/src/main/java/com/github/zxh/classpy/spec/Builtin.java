package com.github.zxh.classpy.spec;

import com.github.zxh.classpy.common.BytesReader;
import com.github.zxh.classpy.common.FilePart;

public class Builtin {

    public static class Uint16 extends FilePart {

        @Override
        protected void readContent(BytesReader reader) {
            setVal(reader.readUnsignedShort());
        }

    }

    public static class Int32 extends FilePart {

        @Override
        protected void readContent(BytesReader reader) {
            setVal(reader.readInt());
        }

    }

    public static class Uint32 extends FilePart {

        @Override
        protected void readContent(BytesReader reader) {
            setVal(reader.readUnsignedInt());
        }

    }

}
