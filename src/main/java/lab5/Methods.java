package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public static double getAverage(List<Integer> list) throws NoSuchElementException {
        return list.stream()
                .mapToDouble(e -> e)
                .average()
                .orElseThrow();
    }

    public static List<String> changeLines(List<String> list) {
        return list.stream()
                .map(String::toUpperCase).map("_new_"::concat)
                .collect(Collectors.toList());
    }

    public static List<Integer> getSquareTheNumbers(List<Integer> list) {
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return list.stream()
                .filter(e -> map.get(e) == 1)
                .map(e -> e * e)
                .collect(Collectors.toList());
    }

    public static void returnLinesStartingWith(String letter, Collection<String> collection) {
        collection.stream()
                .filter(e -> e.startsWith(letter))
                .sorted()
                .forEach(System.out::println);
    }

    public static <T> T lastElementOfTheCollection(Collection<T> collection) throws NoSuchElementException {
        return collection.stream()
                .min(Collections.reverseOrder()).orElseThrow(() -> new NoSuchElementException("Collection is empty. Can't get last element"));
    }

    public static int calculateSumOfEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static Map<Character, String> convertListToMap(List<String> list) {
        return list.stream().collect(Collectors.toMap(k -> k.charAt(0), v -> v.substring(1)));
    }
}
