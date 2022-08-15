package homework28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Task03 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static TreeSet<Integer> numbers = new TreeSet<>();
    static int k = 0;

    public static void main(String[] args) {

        numbers.add(1);
        numbers.add(3);
        numbers.add(2);

        try {
            showMenu();
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }
    }

    public static void showMenu() throws IOException {
        System.out.println("Меню: " +
                "\n1 - добавить число в множество" +
                "\n2 - показать K-тое число из множества" +
                "\n3 - посмотреть все числа" +
                "\n4 - завершить программу" +
                "\nВведите цифру меню: ");

        int number = 0;
        try {
            number = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (number) {
            case 1:
                addNumber();
                break;
            case 2:
                showNumberK();
                break;
            case 3:
                showNumbers();
                break;
            case 4:
                System.exit(1);
                break;
            default: {
                System.out.println("Неверный ввод.");
                showMenu();
            }
        }
    }

    public static void addNumber() throws IOException {
        System.out.println("Введите число:");
        numbers.add(Integer.parseInt(input.readLine()));
        showMenu();
    }

    public static void showNumberK() throws IOException {
        System.out.println("Укажите индекс числа: ");
        int k = Integer.parseInt(input.readLine());
        if (k >= numbers.size()) {
            System.out.println("Сейчас во множестве " + numbers.size() + " чисел. Ваш индекс больше.");
        } else {
            Iterator<Integer> integerIterator = numbers.iterator();
            int counter = 0;
            while (integerIterator.hasNext()) {
                if (k == counter) {
                    System.out.println("В нашем множестве на позиции " + k + " стоит число " + integerIterator.next());
                    return;
                }
                integerIterator.next();
                counter++;
            }
        }
        showMenu();
    }

    public static void showNumbers() throws IOException {
        numbers.forEach(e -> System.out.print(e + " "));
        System.out.println();
        showMenu();
    }
}
