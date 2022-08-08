package homework28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Task01 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите цифры в строку: ");
        String numberLine = input.readLine();

        numberLine = numberLine.replaceAll  ("[^0-9]+", " ");
        String[] numberLineArray = numberLine.split(" ");

        TreeSet<String> result = new TreeSet<>(Arrays.asList(numberLineArray));

        result.forEach(x -> System.out.print(x + " "));

    }
}
