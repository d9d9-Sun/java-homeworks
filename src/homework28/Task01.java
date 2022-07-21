package homework28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Task01 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите цифры в строку: ");
        String numberLine = input.readLine();

        numberLine = numberLine.replace(",", " ");
        String[] numberLineArray = numberLine.split(" ");

        TreeSet<String> result = new TreeSet<>();

        for (String element : numberLineArray) {
            result.add(element);
        }

        result.forEach(x -> System.out.print(x + " "));

    }
}
