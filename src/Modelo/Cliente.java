package Modelo;

public class Cliente extends Usuario{
	
	public Cliente (String nombreUsuario, String contraseña) {
		super(nombreUsuario, contraseña);
		setEsAdmin(false);
	}
	@Override
	public void setEsAdmin(boolean esAdmin) {
		// TODO Auto-generated method stub
		super.setEsAdmin(false);
	}
	@Override
	public void setEsSubscriptor(boolean esSubscriptor) {
		// TODO Auto-generated method stub
		super.setEsSubscriptor(esSubscriptor);
	}
}
