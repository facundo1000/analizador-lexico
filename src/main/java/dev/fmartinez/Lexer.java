package dev.fmartinez;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private String input;
    private int position;
    private int length;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.length = input.length();
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < length) {
            char currentChar = input.charAt(position); // if ( a > b ) { a = 1 ; }
            if (Character.isWhitespace(currentChar)) {
                position++;
                tokens.add(new Token(TokenType.WHITESPACE, String.valueOf(currentChar)));
            } else if (Character.isDigit(currentChar)) {
                tokens.add(readNumber());
            } else if (Character.isLetter(currentChar)) {
                tokens.add(readIdentifierOrKeyword());
            } else {
                tokens.add(readOperator());
            }
        }
        return tokens;
    }

    private Token readNumber() {
        StringBuilder buffer = new StringBuilder();
        while (position < length && Character.isDigit(input.charAt(position))) {
            buffer.append(input.charAt(position++));
        }
        return new Token(TokenType.NUMBER, buffer.toString());
    }

    private Token readIdentifierOrKeyword() {
        StringBuilder buffer = new StringBuilder();
        while (position < length && Character.isLetter(input.charAt(position))) {
            buffer.append(input.charAt(position++));
        }
        String value = buffer.toString();
        if (isKeyword(value)) {
            return new Token(TokenType.KEYWORD, value);
        } else {
            return new Token(TokenType.IDENTIFIER, value);
        }
    }

    private boolean isKeyword(String value) {
        // Definir tus palabras clave aquí
        return value.equals("if") || value.equals("else") || value.equals("while");
    }

    private Token readOperator() {
        char currentChar = input.charAt(position++);
        return new Token(TokenType.OPERATOR, String.valueOf(currentChar));
    }
}
