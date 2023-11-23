package Vista.Paneles.Pestañas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;
import Modelo.Libro;

public class PestanyaCatalogo extends JPanel{
    ControladorUsuario controladorUsuario;
    ControladorCatalogo controladorCatalogo;

    public PestanyaCatalogo(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        this.controladorUsuario = controladorUsuario;
        this.controladorCatalogo = controladorCatalogo;
        
        Color colorFondo = new Color(0, 0, 47);
        setBackground(colorFondo);
        
        actualizarCatalogo();
    }

    public void actualizarCatalogo() {
        //elimina todos los componentes existentes
        this.removeAll();
        this.setLayout(new BorderLayout());

        // Parte superior
        JLabel etiquetaCatalogo = new JLabel("Bienvenido, " + controladorUsuario.getUsuarioActual().getNombreUsuario());
        etiquetaCatalogo.setHorizontalAlignment(JLabel.CENTER);
        etiquetaCatalogo.setForeground(Color.WHITE); // Establece el color del texto a blanco
        add(etiquetaCatalogo, BorderLayout.NORTH);

        // Parte central
        if(!controladorUsuario.getUsuarioActual().getEsSubscriptor()){
            JLabel etiquetaNoSuscriptor = new JLabel("Debes estar suscrito para acceder a la lista de libros disponibles");
            etiquetaNoSuscriptor.setFont(new Font("Arial", Font.BOLD, 20));
            etiquetaNoSuscriptor.setForeground(Color.WHITE);
            etiquetaNoSuscriptor.setHorizontalAlignment(JLabel.CENTER);
            add(etiquetaNoSuscriptor, BorderLayout.CENTER);
        }
        else{
            //lista de libros del catálogo
            ArrayList<Libro> libros = controladorCatalogo.getCatalogoActual().getListaLibros();

            //crea un array de strings para los nombres de los libros
            String[] nombresLibros = new String[libros.size()];
            for (int i = 0; i < libros.size(); i++) {
                nombresLibros[i] = libros.get(i).getNombreLibro();
            }

            //JList con los nombres de los libros
            JList<String> listaLibros = new JList<>(nombresLibros);
            listaLibros.setSelectionBackground(Color.CYAN);
            listaLibros.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // MouseListener a la lista
            listaLibros.addMouseListener(new MouseAdapter() {
                @SuppressWarnings("unchecked")
                public void mouseClicked(MouseEvent evt) {
                    JList<String> list = (JList<String>)evt.getSource();
                    if (evt.getClickCount() == 2) { // Doble clic
            
                        //índice del elemento seleccionado
                        int index = list.locationToIndex(evt.getPoint());
            
                        //libro seleccionado usando index de arriba :)
                        Libro libroSeleccionado = libros.get(index);
            
                        //ventana con la información del libro(sin estilo)
                        JFrame frame = new JFrame("Información del libro");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setSize(300, 200);
                        frame.setLayout(new GridLayout(5, 1));
                        JLabel titulo = new JLabel("Nombre del libro: " + libroSeleccionado.getNombreLibro());
                        titulo.setFont(new Font("Arial", Font.BOLD, 14));
                        frame.add(titulo);
                        frame.add(new JLabel("Autor: " + libroSeleccionado.getAutorLibro()));
                        frame.add(new JLabel("Género: " + libroSeleccionado.getGeneroLibro()));
                        frame.add(new JLabel("Descripción: " + libroSeleccionado.getDescripcion()));
                        frame.setVisible(true);
                    }
                }
            });

            add(new JScrollPane(listaLibros), BorderLayout.CENTER);
        }

        // Actualiza el panel
        this.revalidate();
        this.repaint();
    }
}