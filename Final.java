import clases.Usuario;
import clases.Recepcionista;
import clases.Habitacion;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


//----------------------------------------cambiar funciones de archivos a formato binario-------------------------------

public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Habitacion> habitaciones = new ArrayList<>(); // total de habitaciones
		ArrayList<Habitacion> habitacionesLibres = new ArrayList<>();
		ArrayList<Habitacion> habitacionesOcupadas = new ArrayList<>();
		
        File file = new File("lista de habitaciones");
		
		if(file.exists()) // esto es para que el archivo se cree la primera vez que se ejecute el programa, y que las demas veces solo se abra
		{
			// cargar "habitaciones" con lo datos del archivo
			habitaciones = extraerHabitaciones("lista de habitaciones", habitaciones);
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
		try
		{
		    FileOutputStream archivo = new FileOutputStream(nombrearchivo);
		    ObjectOutputStream salida = new ObjectOutputStream(archivo);
		    archivo.close();
		    salida.close();
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
	
	public static void cargarArchivoDeHabitaciones(String nombreArchivo, ArrayList<Habitacion> habitaciones)
	{
		try
		{
			FileOutputStream archivo =new FileOutputStream(nombreArchivo);
			ObjectOutputStream salida = new ObjectOutputStream(archivo);
			
			for(Habitacion elemento : habitaciones)
			{
				salida.writeObject(elemento);
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
	
	public static ArrayList<Habitacion> extraerHabitaciones(String nombreArchivo, ArrayList<Habitacion> habitaciones)
	{
		File archivo = new File(nombreArchivo);
		
		FileInputStream file = null;
		ObjectInputStream input = null;
		
		try
		{
			file = new FileInputStream(archivo);
			input = new ObjectInputStream(file);
			
			Habitacion dato = (Habitacion) input.readObject();
			
			while(dato != null)
			{
				habitaciones.add(dato);
				
				dato = (Habitacion) input.readObject();
			}
			
			file.close();
			input.close();
		}
		catch(EOFException e)
		{
			try
			{
				file.close();
				input.close();
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return habitaciones;
		
	}

}
