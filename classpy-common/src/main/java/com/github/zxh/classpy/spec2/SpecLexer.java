package com.github.zxh.classpy.spec2;

public class SpecLexer {

    private String spec;
    private int pos;

    public String name() {
        skipWS();
        return "todo";
    }

    private void skipWS() {
        while (pos < spec.length()) {
            char ch = spec.charAt(pos);
            if (Character.isWhitespace(ch)) {
                pos++;
            } else if (ch == '/') {
                skipComment();
            } else {
                break;
            }
        }
    }

    private void skipComment() {
        pos++;
        if (pos >= spec.length() || spec.charAt(pos++) != '*') {
            throw new SpecException("TODO");
        }
        while (pos < spec.length() - 1) {
            if (spec.charAt(pos) == '*' && spec.charAt(pos+1) == '/') {
                pos += 2;
                return;
            }
            pos++;
        }
        throw new SpecException("TODO");
    }

}
