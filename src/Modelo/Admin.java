package Modelo;

public class Admin extends Usuario{
	
	public Admin (String nombreUsuario, String contraseña) {
		
		setEsAdmin(true);
		setEstaSubscripto(true);
		
	}
}
