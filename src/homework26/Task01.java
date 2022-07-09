package homework26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task01 {
    public static void main(String[] args) {
        int arraySize = (int) (Math.random() * 10 + 1); //генерируем длину массива

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 22 - 11); //генерация значений от -10 до 10
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.print("Введите целое число, которое будем делить: ");
        while (true) {
            try {
                n = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Ошибка ввода. Необходимо ввести целое число. \nПовторите ввод: ");
            } catch (Exception e) {
                System.out.print("Ошибка! Повторите ввод: ");
            }
        }

        System.out.println("Массив с результатом деления: " + Arrays.toString(division(n, array)));
    }

    public static int[] division(int n, int[] array) {
        int[] resultArray = new int[array.length];

        try {
            for (int i = 0; i < array.length; i++) {
                resultArray[i] = n / array[i];
            }
        } catch (ArithmeticException e) {
            System.out.println("В массиве присутствует ноль. На ноль делить нельзя. В итоговом массиве может быть ошибка.");
        }

        return resultArray;
    }
}
