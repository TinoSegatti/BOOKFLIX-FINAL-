package Modelo;

public abstract class Usuario {
	
	private String nombreUsuario;
	private String contraseña;
	private boolean esAdmin;
	private boolean esSubscriptor;

	public Usuario(String nombreUsuario, String contraseña){
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean getEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public boolean getEsSubscriptor() {
		return esSubscriptor;
	}
	public void setEsSubscriptor(boolean estaSubscripto) {
		this.esSubscriptor = estaSubscripto;
	}
	
	
}