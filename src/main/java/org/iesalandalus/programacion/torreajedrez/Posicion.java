package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	
	// Declarar atributos
	
	private int fila;
	private char columna;
	
	// Getters y setters
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		if (fila < 1 || fila > 8)
			throw new IllegalArgumentException("ERROOR: Illegal argument????");
		
		this.fila = fila;
	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if (columna != 'a' || columna != 'b' || columna != 'c' || columna != 'd' || columna != 'e' || columna != 'f' || columna != 'g' || columna != 'h')
			throw new IllegalArgumentException("ERROOR: Illegal argument????");
		
		this.columna = columna;
	}
	
	// Constructor
	
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	  
}
