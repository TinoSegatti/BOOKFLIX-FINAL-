package Modelo;

public class Libro {
	
	private String nombreLibro;
	private String generoLibro;
	private String autorLibro;
	private String Descripcion;
	
	public Libro(String nombreLibro, String autorLibro, String generoLibro, String descripcionLibro) {
		setNombreLibro(nombreLibro);
		setAutor(autorLibro);
		setGeneroLibro(generoLibro);
		setDescripcion(descripcionLibro);
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getGeneroLibro() {
		return generoLibro;
	}
	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}
	public String getAutorLibro() {
		return autorLibro;
	}
	public void setAutor(String autorLibro) {
		this.autorLibro = autorLibro;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Nombre del libro: " + nombreLibro + "\n" +
			"Autor del libro: " + autorLibro + "\n" +
			"Género del libro: " + generoLibro + "\n" +
			"Descripción: " + Descripcion + "\n";
	}
}