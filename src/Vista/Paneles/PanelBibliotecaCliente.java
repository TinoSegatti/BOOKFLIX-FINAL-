package Vista.Paneles;

import javax.swing.*;
import java.awt.*;

import Vista.Paneles.Pestañas.*;
import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

public class PanelBibliotecaCliente extends JPanel{
    private JTabbedPane pestañas;

    public PanelBibliotecaCliente(ControladorUsuario controladorUsuario, ControladorCatalogo controladorCatalogo, VistaPrincipal vistaPrincipal){
        this.setLayout(new BorderLayout()); 

        this.pestañas = new JTabbedPane();

        // instancia los paneles
        PestanyaCatalogo pestanyaCatalogo = new PestanyaCatalogo(controladorUsuario, controladorCatalogo, vistaPrincipal);
        PestanyaConfiguracion pestanyaConfiguracion = new PestanyaConfiguracion(controladorUsuario, controladorCatalogo, vistaPrincipal, pestanyaCatalogo);

        pestañas.addTab("Catálogo", pestanyaCatalogo);
        pestañas.addTab("Configuración", pestanyaConfiguracion);

        this.add(pestañas, BorderLayout.CENTER); //añade el JTabbedPane al centro del BorderLayout
    }
}