package lab5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static double getAverage(List<Integer> list) {
        return list.stream().mapToDouble(x -> x).average().orElse(0);
    }
    public static void main(String[] args) {

        System.out.println("----------First method----------");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        double average = getAverage(list);
        System.out.println("List: " + list);
        System.out.println("Average: " + average);

        System.out.println("----------Second method----------");
    }
}
