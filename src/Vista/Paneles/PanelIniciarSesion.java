package Vista.Paneles;

import javax.swing.*;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

import java.awt.*;

public class PanelIniciarSesion extends JPanel {
    private JTextField nombreUsuarioField;
    private JPasswordField contraseniaField;
    private JButton botonIniciarSesion;
    private JButton botonAtras;

    public PanelIniciarSesion(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        Color colorFondo = new Color(0, 0, 47);
        setBackground(colorFondo);

        // Ajusta el tamaño de la imagen
        ImageIcon icono = new ImageIcon(new ImageIcon("C:/Users/noteb/Pictures/bookflix/Captura de pantalla "
        		+ "2023-11-14 235356.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        // Imagen sobre el campo del usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra en horizontal
        gbc.insets = new Insets(10, 10, 100, 10); // Margen superior de 20 píxeles
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
        gbc.gridy = 2; // Incrementé el índice de la fila
        nombreUsuarioField = new JTextField(20);
        gbc.insets = new Insets(0, 0, 50, 0);
        add(nombreUsuarioField, gbc);

        // Contraseña Label
        
        gbc.gridx = 0;
        gbc.gridy = 2; // Incrementé el índice de la fila
        gbc.insets = new Insets(30, 10, 0, 5); // Añadí espacio arriba
        JLabel contraseniaLabel = new JLabel("Contraseña:");
        contraseniaLabel.setForeground(Color.WHITE); // Establece el color del texto a blanco
        add(contraseniaLabel, gbc);

        // Campo de contraseña
        gbc.gridx = 1; // Incrementé el índice de la columna
        gbc.gridy = 3; // Incrementé el índice de la fila
        gbc.insets = new Insets(0, 0, 30, 10); // Añadí menos espacio arriba
        contraseniaField = new JPasswordField(20); // Aumenté el ancho del campo de contraseña
        add(contraseniaField, gbc);


     // Panel de botones
        JPanel panelBotones = new JPanel() {
        	protected void paintComponent(Graphics g) {
        		setLayout(new GridBagLayout());

                // Establece el color de fondo utilizando RGB (por ejemplo, rojo oscuro)
                Color colorFondo = new Color(139, 0, 0);
                setBackground(colorFondo);
            }
        };
        BoxLayout boxLayout = new BoxLayout(panelBotones, BoxLayout.Y_AXIS);
        panelBotones.setLayout(boxLayout);

        this.botonIniciarSesion = new JButton("Iniciar sesión");
        this.botonAtras = new JButton("Atrás");

     // Configuración para el botón Atrás
        botonAtras.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonAtras.getPreferredSize().height));
      
        
        panelBotones.add(botonIniciarSesion);

        // Agregar espacio en blanco entre los botones
        panelBotones.add(Box.createRigidArea(new Dimension(10, 10))); // Ajusta la distancia aquí

        panelBotones.add(botonAtras);

        // Configuración para el panel de botones
        gbc.gridy = 5; // Incrementé el índice de la fila
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra en horizontal
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el panel de botones
        add(panelBotones, gbc);



        botonAtras.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelInicio(controladorUsuario, controladorCatalogo, vistaPrincipal)));

        botonIniciarSesion.addActionListener(e -> {
            String usuario = nombreUsuarioField.getText();
            char[] contrasenia = contraseniaField.getPassword();

            if (controladorUsuario.iniciarSesion(usuario, new String(contrasenia))) {
                if (!controladorUsuario.getUsuarioActual().getEsAdmin()) {
                    vistaPrincipal.cambiarPanel(new PanelBibliotecaCliente(controladorUsuario, controladorCatalogo, vistaPrincipal));
                } else {
                    vistaPrincipal.cambiarPanel(new PanelBibliotecaAdmin(controladorUsuario, controladorCatalogo, vistaPrincipal));
                }
            } else {
                System.out.println("Verifica las credenciales");
            }
        });
    }
}
