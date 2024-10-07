package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDescription {
    public static void main(String[] inpt) {
        //                                       1234          имя бд
        String url = "jdbc:sqlserver://localhost:    ;database=       ;encrypt=true;trustServerCertificate=true;";
        String username = "";
        String password = "";

        // попытка подключиться к бд
        try (Connection connect = DriverManager.getConnection(url, username, password)) {

            String pred_zapros = "SELECT * FROM Books WHERE ID_book = ?";
            //PreparedStatement
            try (PreparedStatement zapros = connect.prepareStatement(pred_zapros)) {

                zapros.setInt(1, Integer.parseInt(inpt[0]));

                try (ResultSet rs = zapros.executeQuery()) {
                    if (rs.next()) {

                        String title = rs.getString("Title");
                        String author = rs.getString("Author");
                        java.sql.Date date = rs.getDate("Year");

                        System.out.println("Сведения о книге:");
                        System.out.println("Название: "+ title);
                        System.out.println("Автор: "+ author);
                        System.out.println("Год издания: "+ date);

                    } else {
                        System.out.println("Книга не найдена");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}
