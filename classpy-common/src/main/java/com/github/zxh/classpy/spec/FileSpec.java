package com.github.zxh.classpy.spec;

import com.moandjiezana.toml.Toml;

import java.nio.ByteOrder;

public class FileSpec {

    private final Toml spec;

    public FileSpec(String spec) {
        this.spec = new Toml().read(FileSpec.class.getResourceAsStream(spec));
    }

    public ByteOrder getByteOrder() {
        String order = spec.getString("byte_order");
        if (order == null) {
            throw new FileSpecException("missing byte_order");
        }
        switch (order.toLowerCase()) {
            case "big-endian": return ByteOrder.BIG_ENDIAN;
            case "little-endian": return ByteOrder.LITTLE_ENDIAN;
            default: throw new FileSpecException("invalid byte_order: " + order);
        }
    }

}
