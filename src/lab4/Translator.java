package lab4;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Translator {
    private final Map<String, String> map;

    public Translator(Map<String, String> map) {
        this.map = map;
    }

    public void translate(Path filePath) throws IOException {
        try (Scanner scanner = new Scanner(filePath)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        }
    }

    private void processLine(String line) {
        String[] words = line.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String originalWord = words[i];
            String lowerCaseWord = originalWord.toLowerCase();
            List<String> translationOptions = findTranslationOptions(lowerCaseWord);
            if (translationOptions.isEmpty()) {
                System.out.print(map.getOrDefault(lowerCaseWord, originalWord) + " ");
                line = line.substring(originalWord.length()).trim();
            }
            else {
                String matchedTranslation = findMatchedTranslation(line.toLowerCase(), translationOptions);
                if (!matchedTranslation.equals("")) {
                    System.out.print(map.get(matchedTranslation) + " ");
                    line = line.substring(matchedTranslation.length()).trim();
                    i += matchedTranslation.split("\\s").length - 1;
                }
                else {
                    System.out.print(map.getOrDefault(lowerCaseWord, originalWord) + " ");
                    line = line.substring(originalWord.length()).trim();
                }
            }
        }
        System.out.println();
    }

    private List<String> findTranslationOptions(String word) {
        List<String> translationOptions = new ArrayList<>();
        for (String str : map.keySet()) {
            if (str.startsWith(word + " ")) {
                translationOptions.add(str);
            }
        }
        translationOptions.sort(Comparator.comparingInt(String::length).reversed());
        return translationOptions;
    }

    private String findMatchedTranslation(String line, List<String> translationOptions) {
        for (String translationOption : translationOptions) {
            if (line.startsWith(translationOption.toLowerCase())) {
                return translationOption.toLowerCase();
            }
        }
        return "";
    }
}


