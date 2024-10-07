package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Delete {
    public static void main(String[] inpt) {
        //                                       1234          имя бд
        String url = "jdbc:sqlserver://localhost:    ;database=         ;encrypt=true;trustServerCertificate=true;";
        String username = "";
        String password = "";

        // попытка подключиться к бд
        try (Connection connect = DriverManager.getConnection(url, username, password)) {

            String pred_zapros = "DELETE FROM Books WHERE Method... = ?";
            //PreparedStatement
            try (PreparedStatement zapros = connect.prepareStatement(pred_zapros)) {

                zapros.setInt(1, Integer.parseInt(inpt[0]));

                int g_zap = zapros.executeUpdate();
                if (g_zap > 0) {
                    System.out.println("Книга удалена!");
                } else {
                    System.out.println("Такой книги нет!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }

}
