import clases.Usuario;
import clases.Recepcionista;
import clases.Habitacion;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


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
			
			Habitacion a1 = new Habitacion(1, "libre", null, "simple");
		    Habitacion a2 = new Habitacion(2, "libre", null, "simple");
    		Habitacion a3 = new Habitacion(3, "libre", null, "simple");
	    	Habitacion a4 = new Habitacion(4, "libre", null, "doble");
	    	Habitacion a5 = new Habitacion(5, "libre", null, "doble");
		    Habitacion a6 = new Habitacion(6, "libre", null, "doble");
	    	Habitacion a7 = new Habitacion(7, "libre", null, "doble");
	    	Habitacion a8 = new Habitacion(8, "libre", null, "suite");
	    	Habitacion a9 = new Habitacion(9, "libre", null, "suite");
	    	Habitacion a10 = new Habitacion(10, "libre", null, "suite");
		
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
		
		System.out.println("BIEN VENIDO A NUESTRO HOTEL");
		System.out.println("\nINGRESE TIPO DE USUARIO:\n -1 administrador\n-2 recepcionista\n-3 huesped");
		int opcion;
		Scanner num = new Scanner(System.in);
		opcion = num.nextInt();
		String nombre, clave;
		Scanner str = new Scanner(System.in);
		
		switch (opcion) {
		case 1:
			
			break;
		case 2:
			System.out.println("INGRESE SU NOMBRE DE USUARIO");
			nombre = str.nextLine();
			System.out.println("INGRESE SU CONTRASEÑA");
			clave = str.nextLine();
			
			if(nombre.equalsIgnoreCase("Agustin Baran") && clave.equals("claveDeAcceso"))
			{
				Recepcionista user1 = new Recepcionista("recepcionista", nombre);
				
				System.out.println("BIEN VENIDO " + nombre);
				Boolean rep;
				Scanner boo = new Scanner(System.in);
				
				do
				{
					System.out.println("\nSELECCIONE UNA ACCION\n-1 consultar habitaciones disponibles\n-2 alquilar habitacion\n-3 consultar habitaciones alquiladas\n -4 cancelar reserva");
					opcion = num.nextInt();
					
					switch (opcion) {
					case 1:
						user1.consultarHabitacionesDisponibles(habitaciones);
						
						break;
					case 2:
						System.out.println("ingrese el nombre del huesped");
						String huesped, clase;
						huesped = str.nextLine();
						System.out.println("ingrese el tipo de habitacion a alquilar");
						clase = str.nextLine();
						
						user1.alquilarHabitacion(habitaciones, habitacionesLibres, habitacionesOcupadas, huesped, clase);
						
						break;
					case 3:
						user1.consultarHabitacionesAlquiladas(habitacionesOcupadas);
						
						break;
					case 4:
						user1.cancelarReserva(habitaciones, habitacionesLibres, habitacionesOcupadas);
						
						break;

					default:
						break;
					}
					
					System.out.println("DESEA EJECUTAR OTRA ACCION? (true/false)");
					rep = boo.nextBoolean();
				}
				while(rep == true);
				
			}
			else
			{
				System.out.println("NOMBRE DE USUARIO O CONTRASEÑA INCORRECTOS");
			}
			
			break;
		case 3:
			
			break;

		default:
			break;
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
