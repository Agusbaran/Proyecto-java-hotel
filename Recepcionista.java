package clases;
import clases.Usuario;
import java.util.ArrayList;
import clases.Habitacion;

public class Recepcionista extends Usuario{
	
	public Recepcionista(String tipo, String nombre)
	{
		super(tipo, nombre);
	}
	
	
	public void consultarHabitacionesDisponibles(ArrayList<Habitacion> habitaciones)
	{
		int i = 0; // contador de habitaciones libres
		
		for(Habitacion elemento : habitaciones)
		{
			if(elemento.getEstado() == "libre")
			{
				i++;
			}
		}
		
		if(i != 0)
		{
			System.out.println("HABITACIONES DISPONIBLES: " + i);
			
			for(Habitacion elemento : habitaciones)
	    	{
	     		if(elemento.getEstado() == "libre")
	    		{
     				System.out.println("habitacion " + elemento.getNumero());
     			}
    		}
		}
		else
		{
			System.out.println("NO HAY HABITACIONES DISPONIBLES");
		}
		
	}
	
	public void alquilarHabitacion(ArrayList<Habitacion> habitaciones, String huesped)
	{
		for(Habitacion elemento : habitaciones)
		{
			if(elemento.getEstado() == "libre")
			{
				elemento.setEstado("ocupado");
				elemento.setHuesped(huesped);
				int h = elemento.getNumero();
				System.out.println("HABITACION " + h + " ALQUILADA POR " + huesped);
				break;
			}
		}
	}
	
	public void consultarHabitacionesAlquiladas(ArrayList<Habitacion> habitaciones)
	{
		for(Habitacion elemento : habitaciones)
    	{
     		if(elemento.getEstado() == "ocupado")
    		{
 				System.out.println("habitacion " + elemento.getNumero() + ": sr/a " + elemento.getHuesped());
 			}
		}
	}
	
	

}
