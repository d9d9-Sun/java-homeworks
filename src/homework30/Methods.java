package homework30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methods {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void showDB() {
        General.dataBase.forEach(x -> System.out.println(x +" "));
    }

    public static void showInfoByID() throws IOException {
        System.out.print("Введите ID: ");
        int id = Integer.parseInt(input.readLine());

        for (Person el : General.dataBase) {
            if (id == el.getId()) {
                System.out.println(el);
            }
        }

    }
}
