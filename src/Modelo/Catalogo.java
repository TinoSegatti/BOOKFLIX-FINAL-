package Modelo;

import java.util.ArrayList;

public class Catalogo {
	
	private ArrayList <Libro> listaLibros;
	
	public Catalogo() {
		this.listaLibros = new ArrayList<>();
	}

	public ArrayList <Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList <Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public void agregarLibro(String nombreLibro, String autorLibro, String generoLibro, String descripcionLibro) {
		Libro libro = new Libro(nombreLibro, autorLibro, generoLibro, descripcionLibro);
		this.listaLibros.add(libro);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Libro libro : listaLibros) {
			sb.append(libro.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}