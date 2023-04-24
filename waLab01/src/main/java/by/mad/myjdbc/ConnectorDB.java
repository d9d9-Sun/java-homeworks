package by.mad.myjdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "d9d9_Sun";
    private static final String PASSWORD = "12345678";
    private static final String DB_NAME = "shop";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void createProductsTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            statement = connection.createStatement();

            boolean bool = statement.execute("CREATE TABLE IF NOT EXISTS products(" +
                    "product_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "product_name CHAR(50), " +
                    "product_country CHAR(50), " +
                    "product_stock INT DEFAULT 0, " +
                    "product_price DECIMAL(10,2));");

            if (!bool) {
                statement.execute("INSERT INTO products(product_name, product_country, product_stock, product_price) " +
                        "VALUES ('potato', 'Belarus', 100, 15.00), " +
                        "('orange', 'Egypt', 50, 20.00), " +
                        "('apple', 'Poland', 75, 5.00), " +
                        "('banana', 'Ecuador', 80, 7.00), " +
                        "('onion', 'Ukraine', 40, 6.99);");
            }

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
