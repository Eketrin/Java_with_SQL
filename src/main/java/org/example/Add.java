package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {
    public static void main(String[] inpt) {
                                               //1234          имя бд
        String url = "jdbc:sqlserver://localhost:    ;database=        ;encrypt=true;trustServerCertificate=true;";
        String username = "";
        String password = "";

        // попытка подключиться к бд
        try (Connection connect = DriverManager.getConnection(url, username, password)) {

            String pred_zapros = "INSERT INTO Books (Title, Author, Year) VALUES (?, ?, ?)";
            //PreparedStatement
            try (PreparedStatement zapros = connect.prepareStatement(pred_zapros)) {

                zapros.setString(1, inpt[0]);
                zapros.setString(2, inpt[1]);
                zapros.setDate(3, java.sql.Date.valueOf(inpt[2]));

                zapros.executeUpdate();
                System.out.println("Книга добавлена!");
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}
