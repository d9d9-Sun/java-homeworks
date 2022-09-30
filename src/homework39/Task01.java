package homework39;

import java.io.*;

public class Task01 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static File file = new File(
            System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "homework39"
                    + File.separator, "single-employee.txt");
    private static StringBuilder temp;
    private static String info;
    private static String[] infoArray;
    private static Employee employee;

    public static void main(String[] args) throws IOException {
        readFile();
        showEmployee();
    }

    public static void showMenu() throws IOException {
        System.out.print("Меню:\n" +
                "1 - ввести данные о сотруднике (заменит все данные)\n" +
                "2 - изменить зарплату сотрудника\n" +
                "0 - закрыть программу\n" +
                "Введите цифру меню: ");
        int choice = Integer.parseInt(input.readLine());
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                changeSalary();
                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Неверный ввод.");
                showMenu();
        }
    }

    public static void readFile() throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        temp = new StringBuilder();
        int i;
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();
        info = String.valueOf(temp);
    }

    public static void showEmployee() throws IOException {
        readFile();

        System.out.println("--------------------\r\nИнформация о сотруднике: ");
        System.out.println(info);
        System.out.println("--------------------");

        showMenu();
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

        writeFile();

        showEmployee();
        showMenu();
    }

    public static void changeSalary() throws IOException {
        readFile();
        infoArray = info.split(", ");
        infoArray[3] = infoArray[3].replace("$/hour", "");

        Employee employee = new Employee();

        employee.setLastName(infoArray[0]);
        employee.setAge(Integer.parseInt(infoArray[1]));
        employee.setPosition(infoArray[2]);
        employee.setSalaryRate(Integer.parseInt(infoArray[3]));

        System.out.println("Введите новую ставку зарплаты в час: ");
        employee.setSalaryRate(Integer.parseInt(input.readLine()));

        writeFile();

        showEmployee();
        showMenu();
    }

    public static void writeFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write((
                employee.getLastName() + ", "
                        + employee.getAge() + ", "
                        + employee.getPosition() + ", "
                        + employee.getSalaryRate() + "$/hour").getBytes());
        outputStream.close();
    }
}
