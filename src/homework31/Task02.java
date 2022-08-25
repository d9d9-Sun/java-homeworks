package homework31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task02 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Минск");
        cities.add("Минск");
        cities.add("Брест");
        cities.add("Могилёв");
        cities.add("Гродно");
        cities.add("Гомель");
        cities.add("Витебск");

        System.out.println("Список всех городов: " + cities);

        System.out.print("Города длиннее шести символов: ");
        cities.stream()
                .filter(x -> x.length() > 6)
                .forEach(x -> System.out.print(x + ", "));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nВведите город: ");
        String inputCity = input.readLine();
        long count = cities.stream()
                .filter(x -> inputCity.equalsIgnoreCase(x))
                .count();
        System.out.println("Город упоминается в базе " + count + " раз");

        System.out.println("Введите букву: ");
        String letter = input.readLine();
        cities.stream()
                .filter(x -> x.startsWith(letter))
                .forEach(x -> System.out.print(x + ", "));
    }
}
