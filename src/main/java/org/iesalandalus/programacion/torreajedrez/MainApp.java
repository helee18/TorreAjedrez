package org.iesalandalus.programacion.torreajedrez;

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
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5);
		
		// Devolvemos la opción elegida
		return opcion;
	}
	
	public static Color elegirColor() {
		
		// Definimos variables locales
		char colorElegido;
		Color color;
		
		// Dsmos valor null al objeto
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
}
