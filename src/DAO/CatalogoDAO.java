package DAO;

import java.sql.*;

import Modelo.*;

public class CatalogoDAO {
    private Connection conexion;

    public CatalogoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregarLibro(String nombreLibro, String autorLibro, String generoLibro, String descripcionLibro){
        System.out.println(nombreLibro);
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO t_catalogo (nombreLibro, autorLibro, generoLibro, descripcionLibro) "
            		+ "VALUES (?, ?, ?, ?)");
            ps.setString(1, nombreLibro);
            ps.setString(2, autorLibro);
            ps.setString(3, generoLibro);
            ps.setString(4, descripcionLibro);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarLibro(String nombreLibro) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM t_catalogo WHERE nombreLibro = ?");
            ps.setString(1, nombreLibro);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeLibro(String nombreLibro){
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM t_catalogo WHERE nombreLibro = ?");
            ps.setString(1, nombreLibro);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Catalogo obtenerCatalogo() {
        try {
            Catalogo catalogo = new Catalogo();
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM t_catalogo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreLibro = rs.getString("nombreLibro");
                String autorLibro = rs.getString("autorLibro");
                String generoLibro = rs.getString("generoLibro");
                String descripcionLibro = rs.getString("descripcionLibro");
                catalogo.agregarLibro(nombreLibro, autorLibro, generoLibro, descripcionLibro);
            }
            return catalogo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}