package homework27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task01 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            showMenu();
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }
    }

    public static void showMenu() throws IOException {
        System.out.println("Меню: " +
                "\n1 - добавить нового пользователя" +
                "\n2 - удалить существующего пользователя" +
                "\n3 - проверить, существует ли пользователь" +
                "\n4 - изменить логин существующего пользователя" +
                "\n5 - изменить пароль существующего пользователя" +
                "\nВведите цифру меню: ");

        int number = 0;
        try {
            number = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (number) {
            case 1:
                UsersList.addUser();
                break;
            case 2:
                UsersList.deleteUser();
                break;
//            case 3:
//                UsersList.checkUser();
//                break;
//            case 4:
//                UsersList.loginChange();
//                break;
//            case 5:
//                UsersList.passwordChange();
//                break;
            default: {
                System.out.println("Неверный ввод.");
                showMenu();
            }
        }
    }
}