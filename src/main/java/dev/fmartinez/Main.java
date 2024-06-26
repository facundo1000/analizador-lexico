package dev.fmartinez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Inicio del programa-------");
        StringBuilder code = new StringBuilder();

        // Mensaje de error si no se proporciona un archivo de entrada
        if (args.length != 1) {
            System.err.println("Usage: java -jar lexical-analyzer.jar <input-file>");
            System.exit(1);
        }

        String filename = args[0]; // Nombre del archivo de entrada

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