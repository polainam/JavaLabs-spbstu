package lab5;

import java.util.*;

public class Main {

    private static void testFirstMethod() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        try {
            double average = Methods.getAverage(list);
            System.out.println("List: " + list);
            System.out.println("Average: " + average);

            list = new ArrayList<>();
            System.out.println("List: " + list);
            average = Methods.getAverage(list);
            System.out.println("Average: " + average);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
    private static void testSecondMethod() {
        List<String> list = new ArrayList<>();
        list.add("testString");
        list.add("test string");
        list.add("TeStStRiNg123");

        System.out.println(Methods.changeLines(list));
        System.out.println(list.getClass());
        System.out.println();
    }

    private static void testThirdMethod() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);

        System.out.println(Methods.getSquareTheNumbers(list));
        System.out.println();
    }

    private static void testFourthMethod() {
        List<String> set = new ArrayList<>();
        set.add("appropriate");
        set.add("algorithm");
        set.add("concept");
        set.add("in");
        set.add("maintain");
        set.add("Stream");
        set.add("API");
        set.add("is");
        set.add("accuracy");
        set.add("flow");

        String letter = "a";

        Methods.returnLinesStartingWith(letter, set);
        System.out.println();
    }

    private static void testFifthMethod() {
        List<String> set = new ArrayList<>();
        set.add("cat1");
        set.add("cat2");
        set.add("cat3");

        try {
            System.out.println(Methods.lastElementOfTheCollection(set));
            Methods.lastElementOfTheCollection(new ArrayList<>());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    private static void testSixthMethod() {
        int[] arr1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = new int[] {3, 5, 9};
        System.out.println(Methods.calculateSumOfEvenNumbers(arr1));
        System.out.println(Methods.calculateSumOfEvenNumbers(arr2));
        System.out.println();
    }

    private static void testSeventhMethod() {
        List<String> list = new ArrayList<>();
        list.add("character");
        list.add("integer");
        list.add("string");
        Map<Character, String> map = Methods.convertListToMap(list);
        for (Map.Entry<Character, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        System.out.println("First method");
        testFirstMethod();

        System.out.println("Second method");
        testSecondMethod();

        System.out.println("Third method");
        testThirdMethod();

        System.out.println("Fourth method");
        testFourthMethod();

        System.out.println("Fifth method");
        testFifthMethod();

        System.out.println("Sixth method");
        testSixthMethod();

        System.out.println("Seventh method");
        testSeventhMethod();
    }
}
