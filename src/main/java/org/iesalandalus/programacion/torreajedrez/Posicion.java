package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		
		this.fila = fila;
	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if (columna != 'a' || columna != 'b' || columna != 'c' || columna != 'd' || columna != 'e' || columna != 'f' || columna != 'g' || columna != 'h')
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		
		this.columna = columna;
	}
	
	// Constructor
	
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	// Constructor copia
	
	public Posicion(Posicion posicionOrigen) {
		setFila(posicionOrigen.getFila());
		setColumna(posicionOrigen.getColumna());
	}

	// hashCode y equals
	
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	// toSring

	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
	
	
}
