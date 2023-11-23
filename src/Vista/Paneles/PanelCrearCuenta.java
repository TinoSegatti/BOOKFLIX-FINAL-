package Vista.Paneles;

import javax.swing.*;
import java.awt.*;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

public class PanelCrearCuenta extends JPanel {
    private JTextField nombreUsuarioField;
    private JPasswordField contraseniaField;
    private JPasswordField confirmarContraseniaField;
    private JButton botonCrearCuenta;
    private JButton botonAtras;

    public PanelCrearCuenta(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Color colorFondo = new Color(0, 0, 47);
        setBackground(colorFondo);
        
        ImageIcon icono = new ImageIcon(new ImageIcon("C:/Users/noteb/Pictures/bookflix/Captura de pantalla "
        		+ "2023-11-14 235356.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        gbc.insets = new Insets(1, 10, 10, 10);
        // imagen sobre "usuario"
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // columnas ocupadas
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.insets = new Insets(5, 10, 1, 10); // margenes
        JLabel imagenLabel = new JLabel(icono);
        add(imagenLabel, gbc);
        
        
        // usuario Label
        gbc.gridx = 0;
        gbc.gridy = 1; //indice de la fila
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE); //color del texto a blanco
        add(usuarioLabel, gbc);

        //campo de texto para el usuario
        gbc.gridy = 2;
        nombreUsuarioField = new JTextField(15);
        add(nombreUsuarioField, gbc);

        //contraseña Label
        gbc.gridy = 3;
        JLabel contraseniaLabel = new JLabel("Contraseña:");
        contraseniaLabel.setForeground(Color.WHITE); //color del texto a blanco
        add(contraseniaLabel, gbc);
        
        //campo de contraseña
        gbc.gridy = 4; //indice de la fila
        contraseniaField = new JPasswordField(15);
        add(contraseniaField, gbc);

        
        //confirmar Contraseña Label
        gbc.gridy = 5;
        JLabel confcontraseniaLabel = new JLabel(" Confirmar Contraseña:");
        confcontraseniaLabel.setForeground(Color.WHITE); //color del texto a blanco
        add(confcontraseniaLabel, gbc);
        
        //campo de confirmar contraseña
        gbc.gridy = 6; //indice de la fila
        confirmarContraseniaField = new JPasswordField(15);
        add(confirmarContraseniaField, gbc);

       
        // panel de botones
        JPanel panelBotones = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //pintar panel de botones
                g.setColor(new Color(0, 0, 47));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        BoxLayout boxLayout = new BoxLayout(panelBotones, BoxLayout.Y_AXIS);
        panelBotones.setLayout(boxLayout);

        this.botonCrearCuenta = new JButton("Crear cuenta");
        this.botonAtras = new JButton("Atrás");
        
        botonCrearCuenta.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonAtras.getPreferredSize().height));
        botonAtras.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonAtras.getPreferredSize().height));
        

        //tamaño preferido para botones
        Dimension buttonSize = new Dimension(150, 30);
        botonCrearCuenta.setPreferredSize(buttonSize);
        botonAtras.setPreferredSize(buttonSize);

        panelBotones.add(botonCrearCuenta);

        //espacio en blanco entre los botones
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));

        panelBotones.add(botonAtras);

        //configuración para el panel de botones
        gbc.gridy = 7; //indice de la fila
        gbc.gridwidth = 2; //columnas
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panelBotones, gbc);
        
        botonAtras.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal)));

        botonCrearCuenta.addActionListener(e -> {
            String usuario = nombreUsuarioField.getText();
            char[] contrasenia = contraseniaField.getPassword();
            char[] confirmarContrasenia = confirmarContraseniaField.getPassword();

            if (controladorUsuario.crearCuenta(usuario, new String(contrasenia), new String(confirmarContrasenia))) {
                vistaPrincipal.cambiarPanel(new PanelBibliotecaCliente(controladorUsuario, controladorCatalogo, vistaPrincipal));
            } else {
                System.out.println("Verifica las credenciales");
            }
        });
    }
}
