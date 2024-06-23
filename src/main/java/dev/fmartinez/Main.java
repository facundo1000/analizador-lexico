package dev.fmartinez;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Inicio del programa-------");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }
        System.out.println("-------Fin del programa-------");
    }
}