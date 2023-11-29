package Vista.Paneles;

import javax.swing.*;
import java.awt.*;

import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

public class PanelInicio extends JPanel {
    private JButton botonIniciarSesion;
    private JButton botonCrearCuenta;

    public PanelInicio(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.botonIniciarSesion = new JButton(" Iniciar sesión");
        this.botonCrearCuenta = new JButton(" Crear cuenta");
        JLabel titulo = new JLabel("<html><br><br>Bookflix<br><br></html>");
        Icon icono = new ImageIcon("C:/Users/noteb/Pictures/bookflix/Captura de pantalla 2023-11-14 235356.png");

        //config de fuente
        Font font = titulo.getFont();
        titulo.setFont(new Font("Courier New", Font.PLAIN, 42));
        titulo.setForeground(new Color(0, 0, 0));
        setLayout(new GridLayout(2, 1)); // 2 filas 1 columna

        JPanel panelTitulo = new JPanel() {
            
            
            protected void paintComponent(Graphics g) {
            	
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(107, 230, 207);
                Color color2 = new Color(0, 0, 47);
                GradientPaint gp = new GradientPaint(width, 0, color1, 0, 0, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panelTitulo.add(titulo, icono);
        

     //color de fondo de los botones
        botonIniciarSesion.setBackground(new Color(107, 230, 207));
        botonCrearCuenta.setBackground(new Color(107, 230, 207));   
        
     //color del texto en los botones
        botonIniciarSesion.setForeground(new Color(0, 0, 0)); 
        botonCrearCuenta.setForeground(new Color(0, 0, 0));   
   
        
        //Panel para los botones
        JPanel panelBotones = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                
                Color color1 = new Color(107, 230, 207);
                Color color2 = new Color(0, 0, 47);
                GradientPaint gp = new GradientPaint(width, 0, color1, 0, 0, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panelBotones.add(botonIniciarSesion);
        panelBotones.add(botonCrearCuenta);

        //componentes
        add(panelTitulo);
        add(panelBotones);

      
        
        botonIniciarSesion.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelIniciarSesion(controladorUsuario, controladorCatalogo, 
        		vistaPrincipal)));
        botonCrearCuenta.addActionListener(e -> vistaPrincipal.cambiarPanel(new PanelCrearCuenta(controladorUsuario, controladorCatalogo, 
        		vistaPrincipal)));
    }
}
