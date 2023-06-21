import clases.Usuario;
import clases.Recepcionista;
import clases.Habitacion;
import java.io.*;
import java.util.ArrayList;


public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
        File file = new File("lista de habitaciones");
		
		if(file.exists()) // esto es para que el archivo se cree la primera vez que se ejecute el programa, y que las demas veces solo se abra
		{
			
		}
		else
		{
			crearArchivo("lista de habitaciones");
			
			Habitacion a1 = new Habitacion(1, "libre", null);
		    Habitacion a2 = new Habitacion(2, "libre", null);
    		Habitacion a3 = new Habitacion(3, "libre", null);
	    	Habitacion a4 = new Habitacion(4, "libre", null);
	    	Habitacion a5 = new Habitacion(5, "libre", null);
		    Habitacion a6 = new Habitacion(6, "libre", null);
	    	Habitacion a7 = new Habitacion(7, "libre", null);
	    	Habitacion a8 = new Habitacion(8, "libre", null);
	    	Habitacion a9 = new Habitacion(9, "libre", null);
	    	Habitacion a10 = new Habitacion(10, "libre", null);
		
	    	habitaciones.add(a1);
	    	habitaciones.add(a2);
	    	habitaciones.add(a3);
	    	habitaciones.add(a4);
	    	habitaciones.add(a5);
	    	habitaciones.add(a6);
	    	habitaciones.add(a7);
	    	habitaciones.add(a8);
	    	habitaciones.add(a9);
	    	habitaciones.add(a10);
	    	
	    	cargarArchivoDeHabitaciones("lista de habitaciones", habitaciones);
		}
		
		
	}
	//-------------------------------------------------FUNCIONES---------------------------------------------------------------
	
	public static void crearArchivo(String nombrearchivo)
	{
		File archivo = new File(nombrearchivo);
		
		try
		{
			
			PrintWriter salida = new PrintWriter(archivo);
			salida.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void cargarArchivoDeHabitaciones(String nombreArchivo, ArrayList<Habitacion> habitaciones)
	{
		File archivo = new File(nombreArchivo);
		
		try
		{
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, false));
			for(Habitacion elemento : habitaciones)
			{
				salida.println(elemento);
			}
			salida.close();
			System.out.println("\nguardado");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
