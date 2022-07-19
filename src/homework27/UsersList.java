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

        for (User element : list) {
            if (element.getLogin().equals(login)) {
                list.remove(element);
            }
        }

        Task01.showMenu();
    }

    public static void showUserList() throws IOException {
        System.out.println("Список пользователей: ");
        list.forEach(x -> System.out.print(x + " "));
        Task01.showMenu();
    }

}
