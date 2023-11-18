package DAO;

import java.sql.*;

import Modelo.*; 

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean existeUsuario(String usuario, String contrasenia) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM t_usuarios WHERE nombreUsuario = ? AND contraUsuario = ?");
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean crearUsuario(String usuario, String contrasenia) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO t_usuarios (nombreUsuario, contraUsuario, esAdmin, esSubscriptor) VALUES (?, ?, ?, ?)");
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            ps.setBoolean(3, false);
            ps.setBoolean(4, false);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suscribirse(String nombreUsuario){
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE t_usuarios SET esSubscriptor = ? WHERE nombreUsuario = ?");
            ps.setBoolean(1, true);
            ps.setString(2, nombreUsuario);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean cancelarSuscripcion(String nombreUsuario){
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE t_usuarios SET esSubscriptor = ? WHERE nombreUsuario = ?");
            ps.setBoolean(1, false);
            ps.setString(2, nombreUsuario);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario obtenerUsuario(String nombreUsuario) throws SQLException{
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM t_usuarios WHERE nombreUsuario = ?");
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario;
                if (rs.getBoolean("esAdmin")) {
                    usuario = new Admin(rs.getString("nombreUsuario"), rs.getString("contraUsuario"));
                } else {
                    usuario = new Cliente(rs.getString("nombreUsuario"), rs.getString("contraUsuario"));
                }
                usuario.setEsSubscriptor(rs.getBoolean("esSubscriptor"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }    
}
