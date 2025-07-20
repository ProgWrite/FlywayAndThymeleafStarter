package org.example;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres25";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Подключение успешно!");
        } catch (Exception e) {
            System.err.println("Ошибка подключения:");
            e.printStackTrace();
        }
    }
}
