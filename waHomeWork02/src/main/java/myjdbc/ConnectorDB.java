package myjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ConnectorDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "d9d9_Sun";
    private static final String PASSWORD = "12345678";
    private static final String DB_NAME = "fitness";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void createFitnessDB() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            statement.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void createFitnessDBTables() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS room_type(" +
                    "room_type_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "room_type_name CHAR(50));");

            statement.execute("CREATE TABLE IF NOT EXISTS sections(" +
                    "section_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "section_name CHAR(50) UNIQUE, " +
                    "section_capacity INT, " +
                    "section_room_type_id INT, " +
                    "CONSTRAINT fk_section_room_type_id " +
                    "FOREIGN KEY (section_room_type_id) REFERENCES room_type (room_type_id));");

            statement.execute("CREATE TABLE IF NOT EXISTS instructor(" +
                    "instructor_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "instructor_fio CHAR(100), " +
                    "instructor_age INT, " +
                    "instructor_section_id INT, " +
                    "CONSTRAINT fk_instructor_section " +
                    "FOREIGN KEY (instructor_section_id) REFERENCES sections (section_id)," +
                    "instructor_experience INT," +
                    "instructor_education CHAR(50));");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void findInstructorOver30() {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            statement = connection.createStatement();

            result = statement.executeQuery("SELECT instructor_fio, instructor_age, room_type_name " +
                    "FROM instructor, room_type, sections " +
                    "WHERE instructor_section_id = section_id " +
                    "AND section_room_type_id = room_type_id " +
                    "AND instructor_age > 30 AND (room_type_name = 'Зал А' OR room_type_name = 'Бассейн')");

            while (result.next()) {
                System.out.println(result.getString("instructor_fio") +
                        ", возраст: " + result.getInt("instructor_age") +
                        ", " + result.getString("room_type_name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                assert result != null;
                result.close();
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void addNewTrainer() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);

            System.out.println("Добавление нового тренера:");
            System.out.print("Введите ФИО: ");
            String fioInput = reader.readLine();
            System.out.print("Введите возраст: ");
            int ageInput = Integer.parseInt(reader.readLine());
            System.out.print("Введите секцию: ");
            String sectionInput = reader.readLine();
            System.out.print("Введите стаж: ");
            int experienceInput = Integer.parseInt(reader.readLine());
            System.out.print("Введите образование: ");
            String educationInput = reader.readLine();

            statement = connection.prepareStatement("INSERT INTO instructor " +
                            "(instructor_fio, instructor_age, instructor_section_id, instructor_experience, instructor_education) " +
                            "VALUES (?, ?, (SELECT section_id FROM sections WHERE section_name = ?), ?, ?)");

            statement.setString(1, fioInput);
            statement.setInt(2, ageInput);
            statement.setString(3, sectionInput);
            statement.setInt(4, experienceInput);
            statement.setString(5, educationInput);

            int row = statement.executeUpdate();

            if (row > 0) {
                System.out.println("Новый тренер добавлен!");
            } else {
                System.out.println("Ошибка, попробуйте снова.");
            }

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void findInstructor() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            System.out.println("Найти тренера по ФИО:");
            System.out.print("Введите ФИО тренера: ");
            String fioInput = reader.readLine();

            statement = connection.prepareStatement("SELECT instructor_fio, instructor_age, section_name, instructor_experience, instructor_education " +
                            "FROM instructor, sections " +
                            "WHERE instructor_section_id = sections.section_id AND instructor_fio = ?;");
            statement.setString(1, fioInput);

            result = statement.executeQuery();

            boolean isHas = false;
            System.out.println("\nИнформация о тренере " + fioInput + ":");
            while (result.next()) {
                isHas = true;
                System.out.println(
                        "Возраст: " + result.getInt("instructor_age") + " лет;\n" +
                                "Секция: " + result.getString("section_name") + ";\n" +
                                "Стаж: " + result.getInt("instructor_experience") + " лет;\n" +
                                "Образование: " + result.getString("instructor_education") + "."
                );
            }
            if (!isHas) {
                System.out.println("Такого тренера не существует!");
            }
            
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                result.close();
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
