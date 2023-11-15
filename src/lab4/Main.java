package lab4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { //исправить
        Map<String, String> map = new HashMap<>();
        Path dictionaryPath = Paths.get("src", "lab4", "resources", "dictionary.txt");
        fillDictionary(map, dictionaryPath);

        Path inputFilePath = Paths.get("src", "lab4", "resources", "input.txt");

        Translator translator = new Translator(map);
        translator.translate(inputFilePath);
    }

    public static void fillDictionary(Map<String, String> map, Path filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s*\\|\\s*");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        }
    }
}
