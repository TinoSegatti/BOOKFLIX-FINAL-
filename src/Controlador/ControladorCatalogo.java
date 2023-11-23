package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import Modelo.*;
import DAO.*;



public class ControladorCatalogo {
    private CatalogoDAO catalogoDAO;
    private Catalogo catalogoActual;

    public ControladorCatalogo(){
        try {
            Connection conexion = ConectorDB.obtenerConexion();
            this.catalogoDAO = new CatalogoDAO(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
        actualizarCatalogoActual();
    }

    public boolean agregarLibro(String nombreLibro,String autorLibro,String generoLibro,String descripcionLibro){
        if(nombreLibro != null && !nombreLibro.isEmpty() && 
           autorLibro != null && !autorLibro.isEmpty() && 
           generoLibro != null && !generoLibro.isEmpty() && 
           descripcionLibro != null && !descripcionLibro.isEmpty()){

            if(catalogoDAO.agregarLibro(nombreLibro, autorLibro, generoLibro, descripcionLibro)){
                System.out.println("Agregar libro: Exitoso");
                actualizarCatalogoActual();
                return true;
            }
            else{
                System.out.println("Agregar libro: Error al agregar libro");
                return false;
            }
        }
        return false;
    }

    public boolean eliminarLibro(String nombreLibro) {
        if (nombreLibro != null && !nombreLibro.isEmpty()) {
            if (catalogoDAO.eliminarLibro(nombreLibro)) {
                System.out.println("Eliminar libro: Exitoso");
                actualizarCatalogoActual();
                return true;
            } else {
                System.out.println("Eliminar libro: Error al eliminar libro");
                return false;
            }
        }
        return false;
    }

    public void actualizarCatalogoActual() {
        this.catalogoActual = catalogoDAO.obtenerCatalogo();
        System.out.println(this.catalogoActual.toString());
    }

    public Catalogo getCatalogoActual(){
        return catalogoActual;
    }

}