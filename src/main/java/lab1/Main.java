package lab1;

import lab1.strategies.*;

import java.util.Scanner;

public class Main {
    private static final int STAY = 1;
    private static final int STEP = 2;
    private static final int RUN = 3;
    private static final int FLIGHT = 4;
    private static final int HORSEBACK_RIDING = 5;
    private static final int EXIT = 0;

    public static MovementStrategy createMovement(int wayToMove) {
        return switch (wayToMove) {
            case STAY -> new StayImpl();
            case STEP -> new StepImpl();
            case RUN -> new RunImpl();
            case FLIGHT -> new FlightImpl();
            case HORSEBACK_RIDING -> new HorsebackRidingImpl();
            default -> null;
        };
    }

    public static void printWaysToMove() {
        String[] waysToMove = {
                "стоять",
                "идти",
                "бежать",
                "лететь",
                "ехать на лошади"
        };

        System.out.println("Герой может передвигаться одним из следующих способов:");
        for (int i = 0; i < waysToMove.length; i++) {
            System.out.println((i + 1) + " - " + waysToMove[i]);
        }
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        Scanner scanner = new Scanner(System.in);

        printWaysToMove();
        System.out.println("Чтобы закончить игру, введите " + EXIT);

        while (true) {
            System.out.print("Введите цифру для изменения движения (1-5), " + EXIT + " для выхода: ");

            if (scanner.hasNextInt()) {
                int wayToMove = scanner.nextInt();

                if (wayToMove == EXIT) {
                    return;
                }

                MovementStrategy movement = createMovement(wayToMove);

                if (movement != null) {
                    hero.setMovement(movement);
                    hero.move();
                } else {
                    System.out.println("Герой так не умеет");
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
                scanner.next();
            }
        }
    }
}
