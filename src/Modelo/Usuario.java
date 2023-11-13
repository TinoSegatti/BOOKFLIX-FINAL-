package Modelo;

public abstract class Usuario {
	
	private String nombreUsuario;
	private String contraseña;
	private boolean esAdmin;
	private boolean estaSubscripto;
	
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
	public boolean getEstaSubscripto() {
		return estaSubscripto;
	}
	public void setEstaSubscripto(boolean estaSubscripto) {
		this.estaSubscripto = estaSubscripto;
	}
	
	
}
