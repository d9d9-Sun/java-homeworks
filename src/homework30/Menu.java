package homework30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void showMenu() throws IOException {
        System.out.print("Меню:\n" +
                "1 - полная распечатка базы данных\n" +
                "2 - распечатка данных по конкретному коду\n" +
                "3 - распечатка данных по конкретному типу штрафа\n" +
                "4 - распечатка данных по конкретному городу\n" +
                "5 - добавление нового человека с информацией о нём\n" +
                "6 - добавление новых штрафов для уже существующей записи\n" +
                "7 - удаление штрафа\n" +
                "8 - замена информации о человеке и его штрафах\n" +
                "0 - закрыть программу\n" +
                "Введите цифру меню: ");
        int choice = Integer.parseInt(input.readLine());
        switch (choice) {
            case 1:
                Methods.showDB();
                break;
            case 2:
                Methods.showInfoByID();
                break;
//            case 3:
//                showInfoByTicketType();
//                break;
//            case 4:
//                showInfoByCity();
//                break;
//            case 5:
//                addCitizen();
//                break;
//            case 6:
//                addTicket();
//                break;
//            case 7:
//                deleteTicket();
//                break;
//            case 8:
//                replaceInfo();
//                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Неверный ввод.");
                showMenu();
        }
    }
}
