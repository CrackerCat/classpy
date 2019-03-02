package com.github.zxh.classpy.spec;

import com.moandjiezana.toml.Toml;

import java.nio.ByteOrder;

public class FileSpec {

    private final Toml spec;

    public FileSpec(String spec) {
        this.spec = new Toml().read(FileSpec.class.getResourceAsStream(spec));
    }

    public ByteOrder getByteOrder() {
        String order = getString("byte_order");
        switch (order.toLowerCase()) {
            case "big-endian": return ByteOrder.BIG_ENDIAN;
            case "little-endian": return ByteOrder.LITTLE_ENDIAN;
            default: throw new FileSpecException("invalid byte_order: " + order);
        }
    }

    public Toml getRootNode() {
        String rootKey = getString("root_node");
        Toml root = spec.getTable(rootKey);
        if (root == null) {
            throw new FileSpecException("missing " + rootKey);
        }
        return root;
    }

    private String getString(String key) {
        String val = spec.getString(key);
        if (val == null) {
            throw new FileSpecException("missing " + key);
        }
        return val;
    }

    // TODO
    public Object get(String key) {
        return spec.toMap().get(key);
    }

}
