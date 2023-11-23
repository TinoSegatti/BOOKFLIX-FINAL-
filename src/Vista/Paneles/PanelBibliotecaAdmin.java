package Vista.Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

public class PanelBibliotecaAdmin extends JPanel {

    public PanelBibliotecaAdmin(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        Color colorFondo = new Color(0, 0, 47);
        setBackground(colorFondo);
        setOpaque(true);
        
        setLayout(new BorderLayout());

        // Parte superior
        JLabel mensajeBienvenida = new JLabel("Bienvenido, " + controladorUsuario.getUsuarioActual().getNombreUsuario());
        mensajeBienvenida.setForeground(Color.WHITE);
        mensajeBienvenida.setBackground(colorFondo);
        add(mensajeBienvenida, BorderLayout.NORTH);

        // Parte central
        JPanel panelCentral = new JPanel(new GridBagLayout());

        //formulario para agregar libro
        JPanel panelAgregarLibro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 15); //espacio entre columnas

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel labelNombreLibro = new JLabel("Nombre del libro a agregar:");
        labelNombreLibro.setOpaque(true);
        panelAgregarLibro.add(labelNombreLibro, gbc);

        gbc.gridy++;
        JTextField nombreLibro = new JTextField(15);
        panelAgregarLibro.add(nombreLibro, gbc);

        gbc.gridy++;
        JLabel labelAutorLibro = new JLabel("Autor del libro:");
        labelAutorLibro.setOpaque(true);
        panelAgregarLibro.add(labelAutorLibro, gbc);

        gbc.gridy++;
        JTextField autorLibro = new JTextField(15);
        panelAgregarLibro.add(autorLibro, gbc);

        gbc.gridy++;
        JLabel labelGeneroLibro = new JLabel("Género del libro:");
        labelGeneroLibro.setOpaque(true);
        panelAgregarLibro.add(labelGeneroLibro, gbc);

        gbc.gridy++;
        JTextField generoLibro = new JTextField(15);
        panelAgregarLibro.add(generoLibro, gbc);

        gbc.gridy++;
        JLabel labelDescripcionLibro = new JLabel("Descripción del libro:");
        labelDescripcionLibro.setOpaque(true);
        panelAgregarLibro.add(labelDescripcionLibro, gbc);

        gbc.gridy++;
        JTextField descripcionLibro = new JTextField(15);
        panelAgregarLibro.add(descripcionLibro, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton botonAgregarLibro = new JButton("Agregar libro");
        panelAgregarLibro.add(botonAgregarLibro, gbc);

        panelCentral.add(panelAgregarLibro);

        // Formulario para eliminar libro
        JPanel panelEliminarLibro = new JPanel(new GridBagLayout());
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 15, 5, 5); // Espacio entre columnas

        JLabel labelNombreLibroEliminar = new JLabel("Nombre del libro a eliminar:");
        labelNombreLibroEliminar.setOpaque(true);
        panelEliminarLibro.add(labelNombreLibroEliminar, gbc);

        gbc.gridy++;
        JTextField nombreLibroEliminar = new JTextField(15);
        panelEliminarLibro.add(nombreLibroEliminar, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton botonEliminarLibro = new JButton("Eliminar libro");
        panelEliminarLibro.add(botonEliminarLibro, gbc);

        panelCentral.add(panelEliminarLibro);

        add(panelCentral, BorderLayout.CENTER);

        // Parte inferior
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        add(botonCerrarSesion, BorderLayout.SOUTH);




        botonAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreLibro.getText();
                String autor = autorLibro.getText();
                String genero = generoLibro.getText();
                String descripcion = descripcionLibro.getText();

                if (controladorCatalogo.agregarLibro(nombre, autor, genero, descripcion)) {
                    System.out.println("Exito: Libro agregado correctamente");
                    //campos de texto vacios
                    nombreLibro.setText("");
                    autorLibro.setText("");
                    generoLibro.setText("");
                    descripcionLibro.setText("");
                } else {
                    System.out.println("Error: No se pudo agregar el libro");
                }
            }
        });

        botonEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreLibroEliminar.getText();

                if (controladorCatalogo.eliminarLibro(nombre)) {
                    System.out.println("Exito: Libro eliminado correctamente");
                    //campo de texto vacio
                    nombreLibroEliminar.setText("");
                } else {
                    System.out.println("Error: No se pudo eliminar el libro");
                }
            }
        });

        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controladorUsuario.cerrarSesion()) {
                    vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal));
                }
            }
        });
    }
}