package clases;

public class Habitacion {
	int numero;
	String estado; // libre u ocupado
	String huesped; // nombre del cliente o null si esta libre
	String tipo; // simple, doble, suite
	
	
	public Habitacion(int numero, String estado, String huesped, String tipo) {
		this.numero = numero;
		this.estado = estado;
		this.huesped = huesped;
		this.tipo = tipo;
	}


	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo()
	{
		this.tipo = tipo;
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
