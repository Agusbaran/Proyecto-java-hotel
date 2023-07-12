package clases;
import java.util.Scanner;
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
     				System.out.println("habitacion " + elemento.getNumero() + " " + elemento.getTipo());
     			}
    		}
		}
		else
		{
			System.out.println("NO HAY HABITACIONES DISPONIBLES");
		}
		
	}
	
	public void alquilarHabitacion(ArrayList<Habitacion> habitaciones, ArrayList<Habitacion> habitacionesLibres, ArrayList<Habitacion> habitacionesOcupadas,String huesped, String clase)
	{
		for(Habitacion elemento : habitaciones)
		{
			if(elemento.getEstado() == "libre" && elemento.getTipo() == clase)
			{
				elemento.setEstado("ocupado");
				elemento.setHuesped(huesped);
				int h = elemento.getNumero();
				System.out.println("HABITACION " + h + " ALQUILADA POR " + huesped);
				break;
			}
			
		}
		
		actualizarListas(habitaciones, habitacionesLibres, habitacionesOcupadas);
	}
	
	public void consultarHabitacionesAlquiladas(ArrayList<Habitacion> habitaciones)
	{
		for(Habitacion elemento : habitaciones)
    	{
     		if(elemento.getEstado() == "ocupado")
    		{
 				System.out.println("habitacion " + elemento.getNumero() + " " + elemento.getTipo() + ": sr/a " + elemento.getHuesped());
 			}
		}
	}
	
	public void actualizarListas(ArrayList<Habitacion> habitaciones, ArrayList<Habitacion> habitacionesLibres, ArrayList<Habitacion> habitacionesOcupadas)
	{
		habitacionesOcupadas.clear();
		habitacionesLibres.clear();
		
		for(Habitacion elemento : habitaciones)
    	{
     		if(elemento.getEstado() == "ocupado")
    		{
 				habitacionesOcupadas.add(elemento);
 			}
     		else
     		{
     			habitacionesLibres.add(elemento);
     		}
		}
		
		System.out.println("listas actualizadas...");
	}
	
	public void cancelarReserva(ArrayList<Habitacion> habitaciones, ArrayList<Habitacion> habitacionesLibres, ArrayList<Habitacion> habitacionesOcupadas)
	{
		int numeroHabitacion = 0, accion;
		String huesped = "-_-";
		Habitacion cuarto;
		
		System.out.println("ingrese el dato de busqueda");
		System.out.println("_1- por numero de habitacion\n_2- por nombre del huesped");
		Scanner num = new Scanner(System.in);
		accion = num.nextInt();
		
		switch (accion) {
		case 1:
			System.out.println("ingrese el numero de habitacion");
		numeroHabitacion = num.nextInt();
		num.close();
			break;
			
		case 2:
			Scanner str = new Scanner(System.in);
		System.out.println("ingrese el nombre del huesped");
		huesped = str.nextLine();
		str.close();
			break;

		default:
			break;
		}
		
		
		for(int i = 0; i < habitaciones.size(); i++)
    	{
			cuarto = habitaciones.get(i);
     		if(cuarto.getNumero() == numeroHabitacion || cuarto.getHuesped().equals(huesped))
    		{
 				cuarto.setEstado("libre");
 				break;
 			}
		}
		
		actualizarListas(habitaciones, habitacionesLibres, habitacionesOcupadas);
		
	}
	

}
