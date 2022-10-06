package homework39;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    private static File file = new File(
            System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "homework39"
                    + File.separator, "corporation-base.txt");
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder temp;
    private static String[] base;
    private static String[] infoArray;
    private static Employee employee;
    private static List<Employee> dataBase;

    public static void showDB() throws IOException {
        readFile();

        System.out.println("--------------------\r\nСписок сотрудников: ");
        dataBase.forEach(System.out::println);
        System.out.println("--------------------");

        Menu.showMenu();
    }

    public static void addEmployee() throws IOException {
        readFile();

        employee = new Employee();

        System.out.println("Введите фамилию: ");
        employee.setLastName(input.readLine());

        System.out.println("Введите возраст: ");
        employee.setAge(Integer.parseInt(input.readLine()));

        System.out.println("Введите должность: ");
        employee.setPosition(input.readLine());

        System.out.println("Введите ставку зарплаты в час: ");
        employee.setSalaryRate(Integer.parseInt(input.readLine()));

        dataBase.add(employee);

        writeFile();

        Menu.showMenu();
    }

    public static void changeEmployee() throws IOException {
        readFile();

        System.out.println("Данные о каком сотруднике изменить? Введите фамилию: ");
        String employeeToChange = input.readLine();

        boolean b = false;
        for (Employee em : dataBase) {
            if (em.getLastName().equalsIgnoreCase(employeeToChange)) {
                System.out.println("Что нужно поменять?\n" +
                        "1 - фамилию\n" +
                        "2 - возраст\n" +
                        "3 - должность\n" +
                        "4 - ставку зарплаты\n" +
                        "Введите цифру: ");
                int choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Введите новую фамилию: ");
                        em.setLastName(input.readLine());
                        break;
                    case 2:
                        System.out.println("Введите новый возраст: ");
                        em.setAge(Integer.parseInt(input.readLine()));
                        break;
                    case 3:
                        System.out.println("Введите новую должность: ");
                        em.setPosition(input.readLine());
                        break;
                    case 4:
                        System.out.println("Введите новую ставку зарплаты: ");
                        em.setSalaryRate(Integer.parseInt(input.readLine()));
                        break;
                    case 0:
                        System.exit(1);
                    default:
                        System.out.println("Неверный ввод.");
                }
                System.out.println("Данные успешно изменены.");
                b = true;
                break;
            }
        }
        if (!b) {
            System.out.println("Такой фамилии нет в базе.");
        }

        writeFile();
        Menu.showMenu();
    }

    public static void deleteEmployee() throws IOException {
        readFile();

        System.out.println("Введите фамилию сотрудника для удаления: ");
        String employeeToDelete = input.readLine();

        boolean b = false;
        for (Employee em : dataBase) {
            if (em.getLastName().equalsIgnoreCase(employeeToDelete)) {
                dataBase.remove(em);
                System.out.println("Сотрудник успешно удалён из базы.");
                b = true;
                break;
            }
        }
        if (!b) {
            System.out.println("Такой фамилии нет в базе.");
        }

        writeFile();
        Menu.showMenu();
    }

    public static void showByLastName() throws IOException {
        readFile();

        System.out.println("Введите фамилию: ");
        String lastName = input.readLine();

        boolean b = false;
        for (Employee em : dataBase) {
            if (em.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(em);
                b = true;
            }
        }
        if (!b) {
            System.out.println("Такой фамилии нет в базе.");
        }

        Menu.showMenu();
    }

    public static void showByAge() throws IOException {
        readFile();

        System.out.println("Введите возраст: ");
        int age = Integer.parseInt(input.readLine());

        boolean b = false;
        for (Employee em : dataBase) {
            if (em.getAge() == age) {
                System.out.println(em);
                b = true;
            }
        }
        if (!b) {
            System.out.println("Сотрудников такого возраста нет в базе.");
        }

        Menu.showMenu();
    }

    public static void showByLetter() throws IOException {
        readFile();

        System.out.println("Введите первую букву фамилии: ");
        char letter = input.readLine().toUpperCase().charAt(0);

        boolean b = false;
        for (Employee em : dataBase) {
            char char0 = em.getLastName().charAt(0);
            if (char0 == letter ) {
                System.out.println(em);
                b = true;
            }
        }
        if (!b) {
            System.out.println("Фамилий на такую букву нет в базе.");
        }

        Menu.showMenu();
    }

    public static void readFile() throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        temp = new StringBuilder();
        int i;
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();
        base = new String(temp).split(System.lineSeparator());
        dataBase = new ArrayList<>();
        for (int j = 0; j < base.length; j++) {
            infoArray = base[j].split(", ");
            infoArray[3] = infoArray[3].replace("$/hour", "");

            employee = new Employee();
            employee.setLastName(infoArray[0]);
            employee.setAge(Integer.parseInt(infoArray[1]));
            employee.setPosition(infoArray[2]);
            employee.setSalaryRate(Integer.parseInt(infoArray[3]));

            dataBase.add(employee);
        }

    }

    public static void writeFile() {
        FileWriter writer;
        try {
            writer = new FileWriter(System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "homework39"
                    + File.separator + "corporation-base.txt");
            for(Employee em: dataBase) {
                writer.write(em + System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
