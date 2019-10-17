package com.github.zxh.classpy.spec2;

public class SpecParser {

    private SpecLexer lexer;

    public FileSpec parse() {
        lexer.name();
        lexer.consume("{");
        while (!lexer.LA("}")) {
            lexer.name(); // type
            lexer.name();
            if (lexer.LA("[")) {
                lexer.consume("[");
                lexer.name();
                lexer.consume("]");
            }
        }
        lexer.consume("}");
        // TODO
        return null;
    }

}
