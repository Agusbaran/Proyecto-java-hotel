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


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getHuesped() {
		return huesped;
	}


	public void setHuesped(String huesped) {
		this.huesped = huesped;
	}
	
	
	

}
