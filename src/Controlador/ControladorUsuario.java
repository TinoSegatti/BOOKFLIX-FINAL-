package Controlador;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.*;
import Modelo.*;

public class ControladorUsuario {
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioActual;

    public ControladorUsuario() {
        try {
            Connection conexion = ConectorDB.obtenerConexion();
            this.usuarioDAO = new UsuarioDAO(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
    }
    
    public boolean iniciarSesion(String usuario, String contrasenia){
        if(usuarioDAO.existeUsuario(usuario, contrasenia)){
            System.out.println("Iniciar sesion: Exitoso");
            try {
                usuarioActual = usuarioDAO.obtenerUsuario(usuario);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            actualizarUsuarioActual();
            return true;
        }
        System.out.println("Iniciar sesion: Error al iniciar sesion");
        return false;
    }

    public boolean crearCuenta(String usuario, String contrasenia, String confirmarContrasenia){
        if(usuario != null && !usuario.isEmpty() && contrasenia != null && !contrasenia.isEmpty() && contrasenia.equals(confirmarContrasenia)){
            if(!usuarioDAO.existeUsuario(usuario, contrasenia)){ // ver esta parte del codigo porque la excepcion no esta manejada
                if(usuarioDAO.crearUsuario(usuario, contrasenia)){
                    System.out.println("Crear cuenta: Exitoso");
                    try {
                        usuarioActual = usuarioDAO.obtenerUsuario(usuario);
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                    actualizarUsuarioActual();
                    return true;
                }
            } 
            else {
                System.out.println("Crear cuenta: El nombre de usuario ya existe");
            }
        }
        System.out.println("Crear cuenta: Error al crear cuenta");
        return false;
    }

    public boolean suscribirse(){
        if(usuarioDAO.suscribirse(usuarioActual.getNombreUsuario())){
            actualizarUsuarioActual();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cancelarSuscripcion(){
        if(usuarioDAO.cancelarSuscripcion(usuarioActual.getNombreUsuario())){
            actualizarUsuarioActual();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cerrarSesion(){
        System.out.println("Cerrar sesion: Exitoso"); // Manejar el cerrado de sesion
        usuarioActual = null;
        try {
            System.out.println(usuarioActual.getNombreUsuario());
        }
        catch(NullPointerException e){
            System.out.println("Usuario actual: null");
        }
        return true;
    }

    public void actualizarUsuarioActual() {
        try {
            // Obtén el usuario de la base de datos
            Usuario usuarioBD = usuarioDAO.obtenerUsuario(usuarioActual.getNombreUsuario());
            if (usuarioBD != null) {
                // Actualiza el usuarioActual con los datos del usuario de la base de datos
                usuarioActual.setContraseña(usuarioBD.getContraseña());
                usuarioActual.setEsAdmin(usuarioBD.getEsAdmin());
                usuarioActual.setEsSubscriptor(usuarioBD.getEsSubscriptor());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
        System.out.println(usuarioActual.getNombreUsuario());
        System.out.println(usuarioActual.getEsSubscriptor());
    }

    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
}