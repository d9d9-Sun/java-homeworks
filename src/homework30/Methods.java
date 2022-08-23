package homework30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methods {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void showDB() throws IOException {
        General.dataBase.forEach(x -> System.out.println(x +" "));
        Menu.showMenu();
    }

    public static void showInfoByID() throws IOException {
        System.out.print("Введите ID: ");
        int id = Integer.parseInt(input.readLine());

        for (Person el : General.dataBase) {
            if (id == el.getId()) {
                System.out.println(el);
            }
        }

        Menu.showMenu();

    }

    public static void showInfoByTicketType() throws IOException {
        System.out.print("Типы штрафов:\n"
                + "1 - Скорость\n"
                + "2 - Переход дороги в неположенном месте\n"
                + "3 - Парковка\n"
                + "4 - Создание аварийной ситуации\n"
                + "Выберите тип штрафа: "
        );
        int n = Integer.parseInt(input.readLine());

        switch (n) {
            case 1:
                for (Person el : General.dataBase) {
                    if (el.getTicketType() == TicketType.SPEED) {
                        System.out.println(el);
                    }
                }
                break;
            case 2:
                for (Person el : General.dataBase) {
                    if (el.getTicketType() == TicketType.CROSSING_ROAD_IN_WRONG_PLACE) {
                        System.out.println(el);
                    }
                }
                break;
            case 3:
                for (Person el : General.dataBase) {
                    if (el.getTicketType() == TicketType.PARKING) {
                        System.out.println(el);
                    }
                }
                break;
            case 4:
                for (Person el : General.dataBase) {
                    if (el.getTicketType() == TicketType.CREATING_AN_EMERGENCY) {
                        System.out.println(el);
                    }
                }
                break;
            default:
                System.out.println("Неверный ввод!");
        }

        Menu.showMenu();

    }
}
