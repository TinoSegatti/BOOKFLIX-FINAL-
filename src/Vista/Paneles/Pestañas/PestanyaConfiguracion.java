package Vista.Paneles.Pestañas;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;
import Vista.Paneles.PanelInicio;

public class PestanyaConfiguracion extends JPanel {
    private JButton botonSuscribirseCancelar;
    private ControladorUsuario controladorUsuario;

    public PestanyaConfiguracion(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, 
    		VistaPrincipal vistaPrincipal, PestanyaCatalogo pestanyaCatalogo) {
        this.controladorUsuario = controladorUsuario;
        GridBagConstraints gbc = new GridBagConstraints();
        Color colorFondo = new Color(0, 0, 47); 
        setBackground(colorFondo);
        
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        gbc.gridy = 1;
        add(botonCerrarSesion, gbc);


        //logica para el boton de suscripción/cancelación
        botonSuscribirseCancelar = new JButton();
        actualizarTextoBoton();
        gbc.gridx = 1;
        add(botonSuscribirseCancelar, gbc);

        botonSuscribirseCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controladorUsuario.getUsuarioActual().getEsSubscriptor()) {
                    System.out.println("Suscripción cancelada");
                    controladorUsuario.cancelarSuscripcion();
                } else {
                    System.out.println("Suscripción realizada");
                    controladorUsuario.suscribirse();
                }

                actualizarTextoBoton(); //actualiza el texto del botón después de la acción
                pestanyaCatalogo.actualizarCatalogo();
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
    
    // metodo para actualizar el texto del boton segu n el estado del usuario
    private void actualizarTextoBoton() {
        if (controladorUsuario.getUsuarioActual().getEsSubscriptor()) {
            botonSuscribirseCancelar.setText("Cancelar Suscripción");
        } else {
            botonSuscribirseCancelar.setText("Suscribirse");
        }
    }
}