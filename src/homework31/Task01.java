package homework31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task01 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() * 100));
        }

        int count = (int) numbers.stream()
                .filter(number -> number % 2 == 0)
                .count();
        System.out.println("Количество чётных: " + count);

        count = (int) numbers.stream()
                .filter(number -> number % 2 != 0)
                .count();
        System.out.println("Количество нечётных: " + count);

        count = (int) numbers.stream()
                .filter(number -> number == 0)
                .count();
        System.out.println("Количество нулей: " + count);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число: ");
        int x = input.read();

        count = (int) numbers.stream()
                .filter(number -> number == x)
                .count();

        if (count == 0) {
            System.out.println("Такого числа нет в списке.");
        } else {
            System.out.println(count);
        }
    }
}
