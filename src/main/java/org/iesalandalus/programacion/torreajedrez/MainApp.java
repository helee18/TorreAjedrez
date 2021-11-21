package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;
	
	public static void main(String[] args) {
		System.out.println("kk");
	}
	
	public static void mostrarTorre(){
		// Mostramos torre o decimos que es nula, si asi es
		try {
			torre.toString();
		}catch (NullPointerException e) {
			System.out.println("ERROR: La torre no existe.");
		}
	}
	
	public static void mostrarMenu() {
		// Mostramos menú
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("---------------------------");
		System.out.println("1.- Crear torre por defecto");
		System.out.println("2.- Crear torre de un color");
		System.out.println("3.- Crear torre de un color en una columna inicial dada ('c' o 'f')");
		System.out.println("4.- Mover torre");
		System.out.println("5.- Salir");
	}
	
	public static int elegirOpcion() {
		
		// Definimos variables locales
		int opcion;
		
		// Mostramos menu y pedimos la eleccion de una opcion hasta que sea valida
		do {
			mostrarMenu();
			System.out.println("Elige una opción");
			opcion = Entrada.entero();
		} while ((opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) || opcion == 5);
		
		// Devolvemos la opción elegida
		return opcion;
	}
	
	public static Color elegirColor() {
		
		// Definimos variables locales
		char colorElegido;
		Color color;
		
		// Damos valor null al objeto
		color = null;
		
		// Mostramos opciones y pedimos que se elija una
		do {
			System.out.println("Elige un color: blanco (b) o negro (n)");
			colorElegido = Entrada.caracter();
		} while (colorElegido != 'b' && colorElegido != 'B' && colorElegido != 'n' && colorElegido != 'N');
		
		// asignamos un valor al objeto sejunla opcion elegida
		if (colorElegido == 'b' || colorElegido == 'B')
			color = Color.BLANCO;
		else
			color = Color.NEGRO;
		
		// Devolvemos el objeto
		return color;
	}
	
	public static char elegirColumnaInicial() {
		
		//Definimos variables locales
		char columnaElegida;
		
		do {
			System.out.println("Elige una columna inicial (c o f)");
			columnaElegida = Entrada.caracter();
		} while (columnaElegida != 'c' && columnaElegida != 'C' && columnaElegida != 'f' && columnaElegida != 'F');
		
		// Devolvemos la columna elegida
		return columnaElegida;
	}
	
	public static void mostrarMenuDirecciones() {
		// Mostramos menú
		System.out.println("MENÚ DE DIRECCIONES");
		System.out.println("---------------------------");
		System.out.println("1.- ARRIBA");
		System.out.println("2.- ABAJO");
		System.out.println("3.- IZQUIERDA");
		System.out.println("4.- DERECHA");
		System.out.println("5.- ENROQUE CORTO");
		System.out.println("6.- ENROQUE LARGO");
	}
	
	public static Direccion elegirDireccion() {
		// Definimos variables locales
		int direccionElegida;
		Direccion direccion;
		
		// Damos valor null al objeto
		direccion = null;
		
		// Mostramos menu y pedimos la eleccion de una opcion hasta que sea valida
		do {
			mostrarMenuDirecciones();
			System.out.println("Elige una opción");
			direccionElegida = Entrada.entero();
		} while (direccionElegida != 1 && direccionElegida != 2 && direccionElegida != 3 && direccionElegida != 4 && direccionElegida != 5 && direccionElegida != 6);
		
		switch (direccionElegida) {
			case 1:
				direccion = Direccion.ARRIBA;
				break;
			case 2:
				direccion = Direccion.ABAJO;
				break;
			case 3:
				direccion = Direccion.IZQUIERDA;
				break;
			case 4:
				direccion = Direccion.DERECHA;
				break;
			case 5:
				direccion = Direccion.ENROQUE_CORTO;
				break;
			case 6:
				direccion = Direccion.ENROQUE_LARGO;
				break;
			default:
				break;
		}
		
		// Devolvemos el objeto
		return direccion;
	}
	
	public static void crearTorreDefecto() {
		// Llamamos al constructor por defecto de torre
		torre = new Torre();
	}
	
	public static void crearTorreColor() {
		// llamamos al constructor torre color de torre
		// pasamos el parametro color haciendo uso del metodo creado anteriormente en esta clase
		torre = new Torre(elegirColor());
	}
	
	public static void crearTorreColorColumna(){
		// llamamos al constructor torre color columna de torre
		// pasamos el parametro color haciendo uso del metodo creado anteriormente en esta clase, al igual que la columna inicial
		torre = new Torre(elegirColor(),elegirColumnaInicial());
	}
	
	public static void mover() {
		// Definimos varibles locales
		Direccion direccion;
		int pasos;
		
		// Para elegir la direccion, llamamos al metodo que hemos creado anteriormente
		direccion = elegirDireccion();
		
		// Segun la opción, movemos los pasos que nos pidamos que introduzcan o realizamos enroque solicitado
		if (direccion.equals(Direccion.ARRIBA) || direccion.equals(Direccion.ABAJO) || direccion.equals(Direccion.IZQUIERDA) || direccion.equals(Direccion.DERECHA)) {
			System.out.println("Introduce los pasos a dar");
			pasos = Entrada.entero();
			try {
				torre.mover(direccion, pasos);
			}catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}else {
			try {
				torre.enrocar(direccion);
			}catch (OperationNotSupportedException | NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	public static void ejecutarOpcion(int opcion) {
		switch (opcion) {
			case 1:
				crearTorreDefecto();
				mostrarTorre();
				break;
			case 2: 
				crearTorreColor();
				mostrarTorre();
				break;
			case 3:
				crearTorreColorColumna();
				mostrarTorre();
				break;
			case 4:
				mover();
				mostrarTorre();
				break;
			default:
				break;
				
		}
	}

}