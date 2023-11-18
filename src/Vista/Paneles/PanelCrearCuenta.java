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
        // Imagen sobre el campo del usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra en horizontal
        gbc.insets = new Insets(5, 10, 1, 10); // Margen superior de 20 píxeles
        JLabel imagenLabel = new JLabel(icono);
        add(imagenLabel, gbc);
        
        
        // Usuario Label
        gbc.gridx = 0;
        gbc.gridy = 1; // Incrementé el índice de la fila
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER; // Alinea a la izquierda
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE); // Establece el color del texto a blanco
        add(usuarioLabel, gbc);

        // Campo de texto para el usuario
        gbc.gridy = 2;
        nombreUsuarioField = new JTextField(15);
        add(nombreUsuarioField, gbc);

        // Contraseña Label
        gbc.gridy = 3;
        JLabel contraseniaLabel = new JLabel("Contraseña:");
        contraseniaLabel.setForeground(Color.WHITE); // Establece el color del texto a blanco
        add(contraseniaLabel, gbc);
        // Campo de contraseña
        gbc.gridy = 4; // Cambiado el índice de la fila
        contraseniaField = new JPasswordField(15);
        add(contraseniaField, gbc);

        
        // Confirmar Contraseña Label
        gbc.gridy = 5;
        JLabel confcontraseniaLabel = new JLabel(" Confirmar Contraseña:");
        confcontraseniaLabel.setForeground(Color.WHITE); // Establece el color del texto a blanco
        add(confcontraseniaLabel, gbc);
        // Campo de confirmar contraseña
        gbc.gridy = 6; // Incrementado el índice de la fila
        confirmarContraseniaField = new JPasswordField(15);
        add(confirmarContraseniaField, gbc);

       
        // Panel de botones
        JPanel panelBotones = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Pintar el fondo del panel aquí si lo necesitas
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
        

        // Establecer el mismo tamaño preferido para ambos botones
        Dimension buttonSize = new Dimension(150, 30); // Ajusta el tamaño según sea necesario
        botonCrearCuenta.setPreferredSize(buttonSize);
        botonAtras.setPreferredSize(buttonSize);

        panelBotones.add(botonCrearCuenta);

        // Agregar espacio en blanco entre los botones
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10))); // Ajusta la distancia aquí

        panelBotones.add(botonAtras);

        // Configuración para el panel de botones
        gbc.gridy = 7; // Incrementé el índice de la fila
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra en horizontal
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el panel de botones
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
