package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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
		// Excepcion si el color es nuelo
		if (color == null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		// Dependiendo del color la posicion es una u otra
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
		// Escepcion si el color es null
		if (color == null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		// Dependiendo del color la posicion es una u otra
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
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		// Excepción si el numero de pasos es 0 o negativo
		if (pasos<1) 
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		
		// Excepcion si la direccion es nula
		if (direccion==null)
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		
		// Dependiendo de la dirección y el color se da un valor distinto a la posicion
		switch (direccion) {
			case ARRIBA:
				
				try {
					if (getColor()==Color.BLANCO)
						setPosicion(new Posicion(posicion.getFila() +pasos, posicion.getColumna()));
					else
						setPosicion(new Posicion(posicion.getFila() -pasos, posicion.getColumna()));
				}catch (IllegalArgumentException e){
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
				
			case ABAJO:
				
				try {
					if (getColor()==Color.BLANCO)
						setPosicion(new Posicion(posicion.getFila() -pasos, posicion.getColumna()));
					else
						setPosicion(new Posicion(posicion.getFila() +pasos, posicion.getColumna()));
				}catch (IllegalArgumentException e){
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
				
			case IZQUIERDA:
				
				try {
					if (getColor()==Color.BLANCO)
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -pasos)));
					else
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +pasos)));
				}catch (IllegalArgumentException e){
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
				
			case DERECHA:
				
				try {
					if (getColor()==Color.BLANCO)
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() +pasos)));
					else
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() -pasos)));
				}catch (IllegalArgumentException e){
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
				
			default:
				break;
			
		}
	}
	
	// Metodo enroque
	public void enrocar(Direccion direccion) throws OperationNotSupportedException {
		// Excepcion si la direccion es nula
		if (direccion==null)
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		
		// Segun el ripo de enroque y el color se intenta hacer una cosa u otra y se lanza excepción si no se puede
		switch (direccion) {
			case ENROQUE_CORTO:
				if (getColor()==Color.BLANCO) {
					if (posicion.getFila()==1 && posicion.getColumna()=='h')
						setPosicion(new Posicion(posicion.getFila(),'f'));
					else 
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}else {	
					if (posicion.getFila()==8 && posicion.getColumna()=='h')
						setPosicion(new Posicion(posicion.getFila(),'f'));
					else 
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			
			case ENROQUE_LARGO:
				if (getColor()==Color.BLANCO) {
					if (posicion.getFila()==1 && posicion.getColumna()=='a')
						setPosicion(new Posicion(posicion.getFila(),'d'));
					else 
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}else {	
					if (posicion.getFila()==8 && posicion.getColumna()=='a')
						setPosicion(new Posicion(posicion.getFila(),'d'));
					else 
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			
			default:
				break;
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

	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	@Override
	// decuelva fila=8, columna=h, color=NEGRO
	public String toString() {
		return "fila="+posicion.getFila()+", columna="+posicion.getColumna()+", color="+color;
	}
	
		
}
