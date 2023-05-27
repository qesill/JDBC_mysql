package org.example;

import java.sql.*;

public class JDBC_create_table_example {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                            "root","");
            if(connection == null) {
                System.out.println("Brak połączenia z bazą danych");
            } else {
                System.out.println("Jest połączenie.");
            }

            statement = connection.createStatement();
            String sql = "CREATE TABLE books ("
                    + " id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "title varchar(100) NOT NULL, "
                    + "published date"

            +");";

            statement.executeUpdate(sql);



        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
