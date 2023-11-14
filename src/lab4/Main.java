package lab4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.io.File.separator;

public class Main {

    //сделать несколько входных файлов
    //input1.txt - слова и выражения в столбец (простой вариант)
    //input2.txt - Полноценный текст со знаками препинания (усложненный вариант)
    //Должно все переводится без изменения исх кода
    //обработать исключения + создать свои

    public static final String DELIMITER = "[\\s,\\.\\n]";
    public static final String DELIMITER_FOR_DICTIONARY = "[\\s*\\|\\s*]";

    public static void main(String[] args) throws IOException { //исправить
        Map<String, String> map = new HashMap<>();
        File file = new File("src" + separator + "lab4" + separator + "resources" + separator + "dictionary.txt");
        fillDictionary(map, file);

        file = new File("src" + separator + "lab4" + separator + "resources" + separator + "input2.txt");
        translate(map, file);
    }

    public static void fillDictionary(Map<String, String> map, File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER_FOR_DICTIONARY);
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

        String tempWord, word;
        while (scanner.hasNext()) {
            word = scanner.next();
            tempWord = word.toLowerCase();

            System.out.println(map.getOrDefault(tempWord, word));
        }
    }
}
