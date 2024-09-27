package asciimirror;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the file path:");
        String path = sc.nextLine();

        try {
            Path filePath = Paths.get(path);

            List<String> lines = Files.readAllLines(filePath);

            // find the longest String
            int maxLength = lines.stream()
                    .mapToInt(String::length)
                    .max().orElse(0);

            // Extend all strings to the maximum length
            List<String> paddedStrings = lines.stream()
                    .map(s -> String.format("%-" + maxLength + "s", s))  // Fill with spaces
                    .toList();

            // mirror the paddedStrings
            List<String> mirroredStrings = paddedStrings.stream()
                    .map(s -> new StringBuilder(s).reverse().toString())
                    .toList();

            // mirror symbols in mirroredStrings
            List<String> mirroredAndReplaced = new ArrayList<>();
            for (String str : mirroredStrings) {
                StringBuilder sb = getReplacedString(str);
                mirroredAndReplaced.add(String.valueOf(sb));
            }

            // Display paddedStrings | mirroredStrings
            for (int i = 0; i < paddedStrings.size(); i++) {
                System.out.println(paddedStrings.get(i) + " | " + mirroredAndReplaced.get(i));
            }

        } catch (InvalidPathException | IOException e) {
            System.out.println("File not found");
        }
    }

    // method to mirror symbols in StringBuilder
    private static StringBuilder getReplacedString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // replace symbols
            switch (c) {
                case '<' -> sb.append('>');
                case '>' -> sb.append('<');
                case '(' -> sb.append(')');
                case ')' -> sb.append('(');
                case '/' -> sb.append('\\');
                case '\\' -> sb.append('/');
                case '[' -> sb.append(']');
                case ']' -> sb.append('[');
                default -> sb.append(c);
            }
        }
        return sb;
    }
}