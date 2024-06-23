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

    /**
     * Tokeniza la entrada
     * @return Lista de tokens
     */
    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < length) {
            Character currentChar = input.charAt(position); // if ( a > b ) { a = 1 ; }
            if (Character.isWhitespace(currentChar)) {
                position++;
                tokens.add(new Token(TokenType.ESPACIO_BLANCO, String.valueOf(currentChar)));
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


    /**
     * Lee un número de la entrada
     * @return Token con el número leído
     */
    private Token readNumber() {
        StringBuilder buffer = new StringBuilder();
        while (position < length && Character.isDigit(input.charAt(position))) {
            buffer.append(input.charAt(position++));
        }
        return new Token(TokenType.NUMERO, buffer.toString());
    }

    private Token readIdentifierOrKeyword() {
        StringBuilder buffer = new StringBuilder();
        while (position < length && Character.isLetter(input.charAt(position))) {
            buffer.append(input.charAt(position++));
        }
        String value = buffer.toString();

        if (isKeyword(value)) {
            return new Token(TokenType.PALABRA_RESERVADA, value);
        } else if (value.matches("[|(),:;+\\-*/%=]")) { //Identifica si es un simbolo especial
            return new Token(TokenType.SIMBOLO_ESPECIAL, value);
        }
        else if (value.matches("[a-zA-Z][a-zA-Z0-9]*")){ //Identifica si es un identificador
            return new Token(TokenType.IDENTIFICADOR, value);
        }
        else {
            return new Token(TokenType.DESCONOCIDO, value); // Si no es ninguno de los anteriores, es desconocido
        }
    }

    private boolean isKeyword(String value) {
        // Definicion de palabras reservadas
        return value.matches("programa|variables|entero|funcion|inicio|fin|si|sino|leer|escribir|modulo|entonces"); // Palabras reservadas
    }

    private Token readOperator() {
        Character currentChar = input.charAt(position++);
        return new Token(TokenType.SIMBOLO_ESPECIAL, String.valueOf(currentChar));
    }
}
