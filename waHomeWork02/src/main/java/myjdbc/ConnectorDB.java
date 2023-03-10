package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "d9d9_Sun";
    private static final String PASSWORD = "12345678";
    private static final String DB_NAME = "fitness";

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
}
