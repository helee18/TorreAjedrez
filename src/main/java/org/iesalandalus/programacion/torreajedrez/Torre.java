package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	// Atributos de las otras clases
	private Color color;
	private Posicion posicion;
	
	// Getter y setters
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		if (color==null)
			throw new NullPointerException("ERROR: No puede haber un color nulo???????");
		
		if (color!=Color.BLANCO && color!=Color.NEGRO)
			throw new IllegalArgumentException("ERROR: Color no valido");
		
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		// Nuevo objeto haciendo uso del constructor copia
		this.posicion = new Posicion(posicion);
	}
	
	
	
	
}
