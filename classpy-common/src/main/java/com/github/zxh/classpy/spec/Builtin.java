package com.github.zxh.classpy.spec;

import com.github.zxh.classpy.common.BytesReader;
import com.github.zxh.classpy.common.FilePart;

public class Builtin {

    public static class Int32 extends FilePart {

        private int val;

        @Override
        protected void readContent(BytesReader reader) {
            val = reader.readInt();
        }

    }

    public static class Uint32 extends FilePart {

        private long val;

        public long getVal() {
            return val;
        }

        @Override
        protected void readContent(BytesReader reader) {
            val = reader.readUnsignedInt();
        }

    }

}
