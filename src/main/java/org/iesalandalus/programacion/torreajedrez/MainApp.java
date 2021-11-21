package org.iesalandalus.programacion.torreajedrez;

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
		System.out.println("------------------");
		System.out.println("1.- Crear torre");
		System.out.println("2.- Mostrar torre");
		System.out.println("3.- Mover torre");
		System.out.println("4.- Salir");
		
	}
}
