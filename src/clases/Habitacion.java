package clases;

public class Habitacion {
	int numero;
	String estado; // libre u ocupado
	String huesped; // nombre del cliente o null si esta libre
	
	
	public Habitacion(int numero, String estado, String huesped) {
		this.numero = numero;
		this.estado = estado;
		this.huesped = huesped;
	}
	
	

}
