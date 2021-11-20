package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	// Atributos de las otras clases
	private Color color;
	private Posicion posicion;
	
	// Constructor por defecto
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'h'));
	}
	
	// Constructor torre con valor de entrada color
	public Torre(Color color) {
		if (color == Color.NEGRO) {
			setColor(Color.NEGRO);
			setPosicion(new Posicion(1, 'h'));
		}
		else if (color == Color.BLANCO) {
			setColor(Color.BLANCO);
			setPosicion(new Posicion(8, 'h'));
		}
	}
	
	// Getter y setters
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		if (color==null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		if (color!=Color.BLANCO && color!=Color.NEGRO)
			throw new IllegalArgumentException("ERROR: Color no valido");
		
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion = new Posicion(posicion);
	}
	
	public void setPosicion(Posicion posicion) {
		// Nuevo objeto haciendo uso del constructor copia
		this.posicion = new Posicion(posicion);
	}
	
	
	
	
}
