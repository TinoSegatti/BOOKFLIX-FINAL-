package Modelo;

import java.util.ArrayList;

public class Catalogo {
	
	private ArrayList <Libro> listaLibros;
	
	public Catalogo() {
		this.listaLibros =new ArrayList<>();
	}

	public ArrayList <Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList <Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

}
