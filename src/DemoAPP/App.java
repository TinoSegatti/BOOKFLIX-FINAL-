package DemoAPP;
import DAO.ConectorDB;
import Controlador.ControladorCatalogo;
import Controlador.ControladorUsuario;
import Vista.VistaPrincipal;

public class App {
    public static void main(String[] args) throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ControladorCatalogo controladorCatalogo = new ControladorCatalogo();
        VistaPrincipal vistaPrincipal = new VistaPrincipal(controladorUsuario, controladorCatalogo);
    }
}