package Modelo;

import java.util.ArrayList;

public class Ranking {
private ArrayList <Libro> listaLibros;
	
	public Ranking() {
		this.listaLibros =new ArrayList<>();
	}

	public ArrayList <Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList <Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

}
