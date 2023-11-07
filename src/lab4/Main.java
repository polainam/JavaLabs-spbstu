package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.io.File.separator;

public class Main {

    //сделать несколько входных файлов
    //input1.txt - слова и выражения в столбец (простой вариант)
    //input2.txt - Полноценный текст со знаками препинания (усложненный вариант)
    //Должно все переводится без изменения исх кода
    //обработать исключения + создать свои

    public static void main(String[] args) throws IOException { //исправить
        Map<String, String> map = new HashMap<>();
        File file = new File("src" + separator + "lab4" + separator + "resources" + separator + "dictionary.txt");
        fillDictionary(map, file);

        file = new File("src" + separator + "lab4" + separator + "resources" + separator + "input.txt");
        translate(map, file);
    }

    public static void fillDictionary(Map<String, String> map, File file) throws IOException {
        FileReader reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
            char symbol = (char) c;
            StringBuilder key = new StringBuilder();
            key.append(symbol);
            StringBuilder value = new StringBuilder();
            while ((symbol = (char) reader.read()) != '|') {
                key.append(symbol);
            }
            key.deleteCharAt(key.length() - 1); //исправить
            reader.read();
            while ((symbol = (char) reader.read()) != '\n') {
                value.append(symbol);
            }
            map.put(key.toString(), value.toString());
        }
    }

    public static void translate(Map<String, String> map, File file) throws FileNotFoundException { //исправить
        Scanner scanner = new Scanner(file);
        String tempWord, word;
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            tempWord = word.toLowerCase();
            System.out.println(map.getOrDefault(tempWord, word));
        }
    }
}
