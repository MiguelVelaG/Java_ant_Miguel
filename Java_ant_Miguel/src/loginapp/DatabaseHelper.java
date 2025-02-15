/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapp;

import java.sql.*;

/**
 *
 * @author Miguel
 */


public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/loginapp";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public static boolean verificarUsuario(String usuario, String contrasena) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, usuario);  // Usamos el nombre de usuario
        stmt.setString(2, contrasena);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    public static boolean registrarUsuario(String nombre, String correo, String usuario, String contrasena) {
    String sql = "INSERT INTO usuarios (nombre, correo, usuario, contraseña) VALUES (?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nombre);  // 'nombre' es el nombre completo, no el usuario
        stmt.setString(2, correo);
        stmt.setString(3, usuario);  // Aquí guardamos el nombre de usuario
        stmt.setString(4, contrasena);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


}
