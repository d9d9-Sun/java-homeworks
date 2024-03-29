package homework27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsersList {
    public static ArrayList<User> list = new ArrayList<>();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void addUser() throws IOException {
        User user = new User();
        System.out.println("Введите логин: ");
        user.setLogin(input.readLine());

        for (User element : list) {
            if (element.getLogin().equals(user.getLogin())) {
                System.out.println("Такой логин существует. Выберите другой.\nВведите логин: ");
                user.setLogin(input.readLine());
            }
        }

        System.out.println("Введите пароль: ");
        user.setPassword(input.readLine());
        list.add(user);
        Task01.showMenu();
    }

    public static void deleteUser() throws IOException {
        System.out.println("Введите логин пользователя для удаления: ");
        String login = input.readLine();

        boolean temp = false;
        for (User element : list) {
            if (element.getLogin().equals(login)) {
                list.remove(element);
                temp = true;
                break;
            }
        }

        if (!temp) {
            System.out.println("Такого пользователя нет в базе.");
        }

        Task01.showMenu();
    }

    public static void checkUser() throws IOException {
        System.out.println("Введите логин: ");
        String login = input.readLine();

        boolean temp = false;
        for (User element : list) {
            if (element.getLogin().equals(login)) {
                System.out.println("Такой пользователь существует.");
                temp = true;
                break;
            }
        }

        if (!temp) {
            System.out.println("Такого пользователя нет в базе.");
        }

        Task01.showMenu();
    }

    public static void loginChange() throws IOException {
        System.out.println("Введите какой логин нужно изменить?");
        String login = input.readLine();

        System.out.println("Введите новый логин: ");
        String newLogin = input.readLine();

        boolean temp = false;
        for (User element : list) {
            if (element.getLogin().equals(login)) {
                element.setLogin(newLogin);
                temp = true;
                break;
            }
        }

        if (!temp) {
            System.out.println("Такого пользователя нет в базе.");
        }

        Task01.showMenu();
    }

    public static void passwordChange() throws IOException {
        System.out.println("Введите для какого логина нужно изменить пароль?");
        String login = input.readLine();

        System.out.println("Введите новый пароль: ");
        String newPassword = input.readLine();

        boolean temp = false;
        for (User element : list) {
            if (element.getLogin().equals(login)) {
                element.setPassword(newPassword);
                temp = true;
                break;
            }
        }

        if (!temp) {
            System.out.println("Такого пользователя нет в базе.");
        }

        Task01.showMenu();
    }

    public static void showUserList() throws IOException {
        System.out.println("Список пользователей: ");
        list.forEach(x -> System.out.print(x + " "));
        Task01.showMenu();
    }

}
