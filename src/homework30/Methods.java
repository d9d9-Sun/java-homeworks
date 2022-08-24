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
                boolean temp = false;
                for (Person el : General.dataBase) {
                    if (el.getTicketType() == TicketType.SPEED) {
                        System.out.println(el);
                        temp = true;
                        break;
                    }
                }
                if (!temp) {
                    System.out.println("Пользователей со штрафами за скорость нет в базе.");
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

    public static void showInfoByCity() throws IOException {
        System.out.print("Города:\n"
                + "1 - Минск\n"
                + "2 - Брест\n"
                + "3 - Гродно\n"
                + "4 - Гомель\n"
                + "Укажите город: "
        );
        int n = Integer.parseInt(input.readLine());

        switch (n) {
            case 1:
                for (Person el : General.dataBase) {
                    if (el.getCity().equalsIgnoreCase("Минск")) {
                        System.out.println(el);
                    }
                }
                break;
            case 2:
                for (Person el : General.dataBase) {
                    if (el.getCity().equalsIgnoreCase("Брест")) {
                        System.out.println(el);
                    }
                }
                break;
            case 3:
                for (Person el : General.dataBase) {
                    if (el.getCity().equalsIgnoreCase("Гродно")) {
                        System.out.println(el);
                    }
                }
                break;
            case 4:
                boolean temp = false;
                for (Person el : General.dataBase) {
                    if (el.getCity().equalsIgnoreCase("Гомель")) {
                        System.out.println(el);
                        temp = true;
                        break;
                    }
                }
                if (!temp) {
                    System.out.println("Пользователей из этого города нет в базе.");
                }
                break;
            default:
                System.out.println("Неверный ввод!");
        }

        Menu.showMenu();
    }

    public static void addCitizen() throws IOException {
        Person person = new Person();
        System.out.println("Введите ID: ");
        person.setId(Integer.parseInt(input.readLine()));

        for (Person el : General.dataBase) {
            if (el.getId() == person.getId()) {
                System.out.println("Такой ID существует. Выберите другой.\nВведите ID: ");
                person.setId(Integer.parseInt(input.readLine()));
            }
        }

        System.out.println("Введите имя: ");
        person.setName(input.readLine());

        System.out.println("Введите город: ");
        person.setCity(input.readLine());

        System.out.print("Типы штрафов:\n"
                + "1 - Скорость\n"
                + "2 - Переход дороги в неположенном месте\n"
                + "3 - Парковка\n"
                + "4 - Создание аварийной ситуации\n"
                + "Выберите тип штрафа: "
        );
        int ticket = Integer.parseInt(input.readLine());

        switch (ticket) {
            case 1:
                person.setTicketType(TicketType.SPEED);
                break;
            case 2:
                person.setTicketType(TicketType.CROSSING_ROAD_IN_WRONG_PLACE);
                break;
            case 3:
                person.setTicketType(TicketType.PARKING);
                break;
            case 4:
                person.setTicketType(TicketType.CREATING_AN_EMERGENCY);
                break;
            default:
                System.out.println("Неверный ввод!");
        }

        General.dataBase.add(person);

        Menu.showMenu();
    }

    public static void addTicket() throws IOException {
        System.out.println("Укажите ID для которого добавить штраф: ");
        int id = Integer.parseInt(input.readLine());

        for (Person el : General.dataBase) {
            if (id == el.getId()) {
                System.out.print("Типы штрафов:\n"
                        + "1 - Скорость\n"
                        + "2 - Переход дороги в неположенном месте\n"
                        + "3 - Парковка\n"
                        + "4 - Создание аварийной ситуации\n"
                        + "Выберите тип штрафа: "
                );
                int ticket = Integer.parseInt(input.readLine());

                switch (ticket) {
                    case 1:
                        el.setTicketType(TicketType.SPEED);
                        break;
                    case 2:
                        el.setTicketType(TicketType.CROSSING_ROAD_IN_WRONG_PLACE);
                        break;
                    case 3:
                        el.setTicketType(TicketType.PARKING);
                        break;
                    case 4:
                        el.setTicketType(TicketType.CREATING_AN_EMERGENCY);
                        break;
                    default:
                        System.out.println("Неверный ввод!");
                }

            }
        }

        Menu.showMenu();
    }

    public static void deleteTicket() throws IOException {
        System.out.println("Укажите ID для которого удалить штраф: ");
        int id = Integer.parseInt(input.readLine());

        for (Person el : General.dataBase) {
            if (id == el.getId()) {
                el.setTicketType(null);
            }
        }

        Menu.showMenu();
    }

    public static void replaceInfo() throws IOException {
        System.out.print("Какую информацию нужно поменять:\n"
                + "1 - ID\n"
                + "2 - Имя\n"
                + "3 - Город\n"
                + "4 - Штраф\n"
                + "Выберите цифру: "
        );
        int n = Integer.parseInt(input.readLine());
    }
}
