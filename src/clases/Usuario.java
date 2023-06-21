package clases;

public abstract class Usuario {
	String tipo;  // administrador, recepcionista o cliente
	String nombre;
	
	
	public Usuario(String tipo, String nombre) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	

}
