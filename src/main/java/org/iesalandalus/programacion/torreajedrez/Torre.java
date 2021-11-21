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
		if (color == Color.BLANCO) {
			setColor(Color.BLANCO);
			setPosicion(new Posicion(1, 'h'));
		}
		else if (color == Color.NEGRO) {
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8, 'h'));
		}
	}
	
	// Constructor torre con valores de entrada color y columna
	public Torre(Color color, char columnaIni) {
		if (color == Color.BLANCO) {
			setColor(Color.BLANCO);
			setPosicion(new Posicion(1, columnaIni));
		}
		else if (color == Color.NEGRO) {
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8, columnaIni));
		}
	}
	
	// Metodo mover
	public static void mover(Direccion direccion, int pasos) {
		if (direccion==null)
			throw new NullPointerException("ERROR: No se puede asignar una direccion nula.");
		
		if (pasos<0) 
			throw new IllegalArgumentException("ERROR: No se puede mover un numero negativo.");
		
		//Si no puede realizar dicho movimiento, debido a que la torre se sale del tablero, se debe lanzar una excepción del tipo 
		//OperationNotSupportedException con un mensaje adecuado y no modificará la posición de la torre. Realiza un commit.
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
