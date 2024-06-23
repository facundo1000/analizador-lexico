package dev.fmartinez;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Inicio del programa-------");
        Scanner scanner = new Scanner(System.in);
        StringBuilder code = new StringBuilder();

        while (scanner.hasNextLine()) {
            code.append("\n").append(scanner.nextLine());

            if (code.toString().contains("fin")) {
                break;
            }
        }
        scanner.close();


        Lexer lexer = new Lexer(code.toString());
        List<Token> tokens = lexer.tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }
        System.out.println("-------Fin del programa-------");
    }
}