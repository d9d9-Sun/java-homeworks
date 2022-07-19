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
            System.out.println("Ошибка" + e);
        }
    }

    public static void showMenu() throws IOException {
        System.out.println("Введите цифру: " +
                "\n1 - добавить нового пользователя" +
                "\n2 - удалить существующего пользователя" +
                "\n3 - проверить, существует ли пользователь" +
                "\n4 - изменить логин существующего пользователя" +
                "\n5 - изменить пароль существующего пользователя");

        int number = 0;
        try {
            number = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (number) {
            case 1:
                UsersList.add();
                break;
            case 2:
                UserList.delete();
                break;
            case 3:
                UserList.show();
                break;
            case 4:
                UserList.loginChange();
                break;
            case 5:
                UserList.passwordChange();
                break;
            default:
                throw new IllegalArgumentException("Неверный ввод");
        }
    }
}