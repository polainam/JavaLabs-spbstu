package lab2;

import lab2.Annotations.ParameterNamesAnnotation;
import lab2.Annotations.RepeatingAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Polina", 20, "89223332502");
            Class<? extends Person> personClass = person.getClass();

            for (Method method : personClass.getDeclaredMethods()) {
                processMethod(person, method);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void processMethod(Person person, Method method) throws InvocationTargetException, IllegalAccessException {
        if (method.isAnnotationPresent(RepeatingAnnotation.class)) {
            int numberOfRepetitions = method.getAnnotation(RepeatingAnnotation.class).numberOfRepetitions();
            int modifiers = method.getModifiers();
            if (Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers)) {
                method.setAccessible(true);
                if (method.getParameterCount() != 0) {
                    processMethodWithParameters(person, method, numberOfRepetitions);
                } else {
                    processMethodWithoutParameters(person, method, numberOfRepetitions);
                }
            }
        }
    }

    private static void processMethodWithParameters(Person person, Method method, int numberOfRepetitions) throws InvocationTargetException, IllegalAccessException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] parameterNames = getParameterNames(method);

        Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < numberOfRepetitions; i++) {
                System.out.println("Введите следующие параметры:");
                Object[] args = new Object[parameterTypes.length];

                for (int j = 0; j < parameterTypes.length; j++) {
                    System.out.print(parameterNames[j] + ": ");
                    args[j] = getInputValue(scanner, parameterTypes[j]);
                }
                System.out.println(method.invoke(person, args));
            }
        }

    private static void processMethodWithoutParameters(Person person, Method method, int numberOfRepetitions) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < numberOfRepetitions; i++) {
            System.out.println(method.invoke(person));
        }
    }

    private static String[] getParameterNames(Method method) {
        ParameterNamesAnnotation annotation = method.getAnnotation(ParameterNamesAnnotation.class);
        return annotation.value();
    }

    private static Object getInputValue(Scanner scanner, Class<?> parameterType) {
        if (parameterType == String.class) {
            return scanner.next();
        } else if (parameterType == Integer.class || parameterType == Integer.TYPE) {
            return scanner.nextInt();
        } else if (parameterType == Boolean.class || parameterType == Boolean.TYPE) {
            return scanner.nextBoolean();
        }
        return null;
    }
}
