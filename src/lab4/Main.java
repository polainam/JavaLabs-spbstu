package lab4;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import static java.io.File.separator;

public class Main {

    //сделать несколько входных файлов
    //input1.txt - слова и выражения в столбец (простой вариант)
    //input2.txt - Полноценный текст со знаками препинания (усложненный вариант)
    //Должно все переводится без изменения исх кода
    //обработать исключения + создать свои

    public static final String DELIMITER = "[\\s,\\n]";

    public static void main(String[] args) throws IOException { //исправить
        Map<String, String> map = new HashMap<>();
        File file = new File("src" + separator + "lab4" + separator + "resources" + separator + "dictionary.txt");
        fillDictionary(map, file);

        file = new File("src" + separator + "lab4" + separator + "resources" + separator + "input1.txt");
        translate(map, file);
    }

    public static void fillDictionary(Map<String, String> map, File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s*\\|\\s*");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        }
    }

    public static void translate(Map<String, String> map, File file) throws FileNotFoundException { //исправить
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile(DELIMITER);
        scanner.useDelimiter(pattern);
        StringBuilder word = new StringBuilder();
        ArrayList<String> translationOptions = new ArrayList<>();
        while (scanner.hasNext()) {
            word.append(scanner.next().toLowerCase());
            if (String.valueOf(word).equals("")) {
                System.out.println();
            }
            for (String str: map.keySet()) {
                if (str.startsWith(String.valueOf(word))) {
                    translationOptions.add(str);
                }
            }
            if (translationOptions.size() == 0) {
                System.out.print(word + " ");
                word.delete(0, word.length());
            }
            else if (translationOptions.size() == 1 && translationOptions.get(0).equals(String.valueOf(word))) {
                System.out.print(map.get(String.valueOf(word)) + " ");
                translationOptions.clear();
                word.delete(0, word.length());
            }
            else {
                while (scanner.hasNext() && !word.isEmpty()) {
                    word.append(" ");
                    word.append(scanner.next().toLowerCase());
                    ArrayList<String> tempTranslationOptions = new ArrayList<>(translationOptions);
                    for (String str:tempTranslationOptions) {
                        if (!str.startsWith(String.valueOf(word))) {
                            translationOptions.remove(str);
                        }
                    }
                    if (translationOptions.size() == 0) {
                        if (map.get(String.valueOf(word)) != null) {
                            System.out.println(map.get(String.valueOf(word)));
                        }
                        else {
                            String[] parts = String.valueOf(word).split("\\s");
                            for (String str:parts) {
                                System.out.print(map.getOrDefault(str, str) + " ");
                            }
                        }
                        word.delete(0, word.length());
                    }
                    else if (translationOptions.size() == 1 && translationOptions.get(0).equals(String.valueOf(word))) {
                        System.out.print(map.get(String.valueOf(word)) + " ");
                        word.delete(0, word.length());
                    }
                }
                translationOptions.clear();
            }
        }
    }
}
