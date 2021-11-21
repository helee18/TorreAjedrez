package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;
	
	public static void main(String[] args) {
		System.out.println("kk");
	}
	
	public static void mostrarTorre(){
		try {
			torre.toString();
		}catch (NullPointerException e) {
			System.out.println("ERROR: La torre no existe.");
		}
	}
	
	public static void mostrarMenu() {
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("---------------------------");
		System.out.println("1.- Crear torre por defecto");
		System.out.println("2.- Crear torre de un color");
		System.out.println("3.- Crear torre de un color en una columna inicial dada ('c' o 'f')");
		System.out.println("4.- Mover torre");
		System.out.println("5.- Salir");
	}
	
	public static int elegirOpcion() {

		int opcion;
		
		do {
			mostrarMenu();
			System.out.println("Elige una opción");
			opcion = Entrada.entero();
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5);
		
		return opcion;
	}
	
	public static Color elegirColor() {

		char colorElegido;
		Color color;
		
		color = null;
		
		do {
			System.out.println("Elige un color: blanco (b) o negro (n)");
			colorElegido = Entrada.caracter();
		} while (colorElegido != 'b' && colorElegido != 'B' && colorElegido != 'n' && colorElegido != 'N');
		
		if (colorElegido == 'b' || colorElegido == 'B')
			color = Color.BLANCO;
		else
			color = Color.NEGRO;
		
		return color;
	}
}
