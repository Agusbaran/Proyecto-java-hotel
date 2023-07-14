import clases.Usuario;
import clases.Habitacion;
import java.util.ArrayList;

	public class Huesped extends Usuario {
		String mail;
		int nHabitacion;
		

		
			public Huesped(String tipo, String nombre, String mail, int nHabitacion) {
			super(tipo, nombre);
			this.mail = mail;
			this.nHabitacion = nHabitacion;
		}
			
			public String getMail() {
				return mail;
			}



			public void setMail(String mail) {
				this.mail = mail;
			}



			public int getnHabitacion() {
				return nHabitacion;
			}



			public void setnHabitacion(int nHabitacion) {
				this.nHabitacion = nHabitacion;
			}



			public void verReserva(String nombre, ArrayList<Habitacion> habitaciones)
			{
				for(Habitacion elemento : habitaciones)
				{
					if (elemento.getHuesped().equalsIgnoreCase(nombre))
					{
						System.out.println("SR. "+ nombre);
						System.out.println("habitacion" + elemento.getNumero() + " " + elemento.getTipo());
						break;
					}
				}
		   }
	}

