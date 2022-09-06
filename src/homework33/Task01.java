package homework33;

import java.util.Arrays;

public class Task01 {
    static int sum = 0;
    static double avg = 0;

    public static void main(String[] args) throws InterruptedException {
        RandomNumbers thread1 = new RandomNumbers();
        thread1.run();
        System.out.println(Arrays.toString(RandomNumbers.array));

        while (thread1.isAlive()) ;

        Runnable thread2 = () -> {
            for (int i = 0; i < RandomNumbers.array.length; i++) {
                sum += RandomNumbers.array[i];
            }
        };
        thread2.run();
        System.out.println("Сумма элементов массива: " + sum);

        Runnable thread3 = () -> {
            avg = (double) sum / RandomNumbers.array.length;
        };
        thread3.run();
        System.out.println("Среднее арифметическое значение массива: " + avg);

    }
}
