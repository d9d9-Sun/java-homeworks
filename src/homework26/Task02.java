package homework26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task02 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите число: ");
            getNumber(Integer.parseInt(input.readLine()));
        } catch (NegativeNumberException | IllegalArgumentException | IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }

    public static void getNumber(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException();
        } else if (n > 100) {
            throw new IllegalArgumentException("Число больше ста.");
        } else {
            System.out.println(n);
        }
    }

    public static class NegativeNumberException extends Exception {
        public NegativeNumberException() {
            super("Вы ввели отрицательное число.");
        }
    }
}
