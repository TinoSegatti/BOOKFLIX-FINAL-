package Modelo;

public class Admin extends Usuario{
	
	public Admin (String nombreUsuario, String contraseña) {
		super(nombreUsuario, contraseña);
		setEsAdmin(true);
		setEsSubscriptor(true);	
	}
	@Override
	public void setEsAdmin(boolean esAdmin) {
		// TODO Auto-generated method stub
		super.setEsAdmin(true);
	}
	@Override
	public void setEsSubscriptor(boolean esSubscriptor) {
		// TODO Auto-generated method stub
		super.setEsSubscriptor(true);
	}
}