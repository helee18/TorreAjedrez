package org.iesalandalus.programacion.torreajedrez;

public class MainApp {

	private static Torre torre;
	
	public static void main(String[] args) {
		System.out.println("kk");
		mostrarTorre();
	}
	
	public static void mostrarTorre(){
		try {
			torre.toString();
		}catch (NullPointerException e) {
			System.out.println("ERROR: La torre no existe.");
		}
	}

}
