package lab4;

import lab4.exceptions.FileReadException;
import lab4.exceptions.InvalidFileFormatException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        Path dictionaryPath = Paths.get("src", "lab4", "resources", "dictionary.txt");
        Path inputFilePath = Paths.get("src", "lab4", "resources", "input.txt");

        try {
            fillDictionary(map, dictionaryPath);
            Translator translator = new Translator(map);
            translator.translate(inputFilePath);
        } catch (FileReadException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getClass());
            Throwable cause = e.getCause();
            if (cause != null) {
                System.err.println(cause.getClass());
            }
        } catch (InvalidFileFormatException e) {
            System.err.println("Error filling dictionary at line " + e.getLineNumber() + ": " + e.getMessage());
            System.out.println("The file must comply with the format: word or expression | translation");
        }
    }

    public static void fillDictionary(Map<String, String> map, Path filePath) throws InvalidFileFormatException, FileReadException {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s\\|\\s");
                lineNumber++;
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
                else {
                    throw new InvalidFileFormatException(lineNumber, "Incorrect dictionary format in file: " + filePath);
                }
            }
        } catch (IOException e) {
            throw new FileReadException(e.getMessage(), e);
        }
    }
}
