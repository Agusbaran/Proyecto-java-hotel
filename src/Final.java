import clases.Usuario;
import clases.Recepcionista;
import clases.Habitacion;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import clases.*;
import java.util.Iterator;

public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Habitacion> habitaciones = new ArrayList<>(); // total de habitaciones
		ArrayList<Habitacion> habitacionesLibres = new ArrayList<>();
		ArrayList<Habitacion> habitacionesOcupadas = new ArrayList<>();
		ArrayList<Recepcionista> recepcionistas = new ArrayList<>();
		
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
			
			
			Scanner lector = new Scanner(System.in);
			
			boolean programaActivo = true;
			
			do {
		System.out.println("¿Que operacion quiere realizar?");
		System.out.println("1. Agregar recepcionista\n2. Eliminar recepcionista \n3. Modificar recepcionista \n4. Ver recepcionistas \n5. Cerrar operacion");
		opcion = lector.nextInt();
		if(opcion == 1) {
			System.out.println("Nombre de recepcionista");
			nombre = lector.next();
			System.out.println("Introduce la clave del recepcionista");
		    clave = lector.nextLine();
			
			Recepcionista a = new Recepcionista("recepcionista", "-", "-");
			a.setNombre(nombre);
			a.setClave(clave);
			recepcionistas.add(a);
		} else if (opcion == 2) {
			System.out.println("Nombre de recepcionista");
			nombre = lector.next();
			Iterator<Recepcionista> it = recepcionistas.iterator();
			while (it.hasNext()) {
				Recepcionista a = it.next();
				if(a.getNombre().equals(nombre)) {
					it.remove();
				}
			}
			} else if (opcion == 3) {
				System.out.println("Nombre de recepcionista");
				nombre = lector.nextLine();
				System.out.println("Nuevo nombre de recepcionista");
				String nombre2 = lector.nextLine();
				System.out.println("Introduce la nueva clave del recepcionista");
				String clave2 = lector.nextLine();

				Iterator<Recepcionista> it = recepcionistas.iterator();
				while (it.hasNext()) {
					Recepcionista a = it.next();
					if(a.getNombre().equals(nombre)) {
						a.setNombre(nombre2);
						a.setClave(clave2);
					}
				}
		} else if (opcion == 4) {
			for(Recepcionista a: recepcionistas) {
				System.out.println("nombre: "+ a.getNombre()+ " , clave"+ a.getClave());
		}
		}
		else if (opcion == 5) {
		programaActivo = false;
		}else {
			System.out.println("opcion invalida");
		}	
		}	
			while(programaActivo);
		

			break;
		case 2: // recepcionista
			System.out.println("INGRESE SU NOMBRE DE USUARIO");
			nombre = str.nextLine();
			System.out.println("INGRESE SU CONTRASEÑA");
			clave = str.nextLine();
			
			if(nombre.equalsIgnoreCase("Agustin Baran") && clave.equals("claveDeAcceso"))
			{
				Recepcionista user1 = new Recepcionista("recepcionista", nombre, clave);
				
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
						System.out.println("ingrese el tipo de habitacion a alquilar (simple, doble o suite)");
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
		case 3: // huesped
			
			System.out.println("INGRESE SU NOMBRE");
			nombre = str.nextLine();
			Huesped huesped1 = new Huesped("huesped", nombre, "-", 0);
			
			System.out.println("BIEN VENIDO " + huesped1.getNombre());
			
			huesped1.verReserva(huesped1.getNombre(), habitaciones);

			
			break;

		default:
			break;
		}
		
		actualizarArchivoDeHabitaciones("lista de habitaciones", habitaciones);

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
	
	public static void actualizarArchivoDeHabitaciones(String nombreArchivo, ArrayList<Habitacion> habitaciones)
	{
		try
		{
			File file = new File(nombreArchivo);
			FileOutputStream flujoSalida =new FileOutputStream(file, false);
			
			flujoSalida.close();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
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
}

 