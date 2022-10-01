package homework39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void showMenu() throws IOException {
        System.out.print("Меню:\n" +
                "1 - показать список сотрудников\n" +
                "2 - добавить сотрудника\n" +
                "3 - изменить информацию о сотруднике\n" +
                "4 - удалить сотрудника из базы\n" +
                "5 - поиск данных о сотруднике по фамилии\n" +
                "6 - поиск сотрудников по возрасту\n" +
                "7 - поиск сотрудников по первой букве фамилии\n" +
                "0 - закрыть программу\n" +
                "Введите цифру меню: ");
        int choice = Integer.parseInt(input.readLine());
        switch (choice) {
            case 1:
                Methods.showDB();
                break;
            case 2:
                Methods.addEmployee();
                break;
            case 3:
                Methods.changeEmployee();
                break;
            case 4:
                Methods.deleteEmployee();
                break;
            case 5:
                Methods.showByLastName();
                break;
            case 6:
                Methods.showByAge();
                break;
            case 7:
                Methods.showByLetter();
                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Неверный ввод.");
                showMenu();
        }
    }
}
