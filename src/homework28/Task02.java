package homework28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Task02 {
    static TreeSet<Integer> numbers = new TreeSet<>();
    static TreeSet<Integer> temp = new TreeSet<>();
    static boolean bool = true;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Введите количество элементов (кратно 8): ");
                count = Integer.parseInt(input.readLine());
                if (count % 8 != 0) {
                    throw new IOException("Число должно быть кратно 8!");
                }
                break;
            } catch (Exception e) {
                System.out.print("Ошибка! Повторите ввод: ");
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Введите элемент " + (i + 1) + ": ");
            numbers.add(Integer.parseInt(input.readLine()));
        }

        while (bool) {
            pairSum();
        }

        numbers.forEach(e -> System.out.print("Результат: " + e));
    }

    public static void pairSum() {
        if (numbers.size() == 1) {
            bool = false;
        }
        while (numbers.size() > 1) {
            Integer a, b;
            a = numbers.first();
            numbers.remove(numbers.first());
            b = numbers.first();
            numbers.remove(numbers.first());
            temp.add(a + b);

        }
        numbers = temp;
    }
}
