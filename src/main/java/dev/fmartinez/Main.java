package dev.fmartinez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Inicio del programa-------");
//        Scanner scanner = new Scanner(System.in);
        StringBuilder code = new StringBuilder();
//
//        while (scanner.hasNextLine()) {
//            code.append("\n").append(scanner.nextLine());
//
//            if (code.toString().contains("fin")) {
//                break;
//            }
//        }
//        scanner.close();
//
//
//        Lexer lexer = new Lexer(code.toString());
//        List<Token> tokens = lexer.tokenize();
//        for (Token token : tokens) {
//            System.out.println(token);
//        }

        if (args.length != 1) {
            System.err.println("Usage: java -jar lexical-analyzer.jar <input-file>");
            System.exit(1);
        }

        String filename = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.readLine() != null) {
                code.append(reader.readLine());
            }
            Lexer lexer = new Lexer(code.toString());

            for (Token token : lexer.tokenize()) {
                System.out.println(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("File read successfully");
        }

        System.out.println("-------Fin del programa-------");
    }
}