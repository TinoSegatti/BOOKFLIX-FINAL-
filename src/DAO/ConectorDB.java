package DAO;
import java.sql.*;

public class ConectorDB {
    private static final String URL = "jdbc:mysql://localhost:3306/bookflixdb";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "123456789";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
    }
}