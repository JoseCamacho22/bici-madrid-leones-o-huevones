package ut01.biciMadrid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



import java.nio.file.Path;


public class Main {
	/*
	 Desarrollar un programa para la gestión del programa de alquiler de bicis de Madrid.


	El programa principal de pruebas tendrá una colección que almacena las bicis y los clientes

	Mostrará un menu desde el que un usuario :
	- Dar de alta a un nuevo usuario
	- Consultar su saldo
	- Recargar saldo
	- Alquilar una bici si dispone de saldo, generándose un objeto orden con la información del cliente, la bici, fecha y hora de sal y el aparcamiento de salida, 
	- Devolver bici: Al devolver la bici al mismo o distinto Aparcadero, guardará la fecha de entrada y aparcadero de entrada en el objeto orden y le cobrará al usuario según las siguientes tarifas:

	Abonados
		0-30 min	0,50 €	
		31-60 min	1,10 €
		61-90 min	1,70 €	
		91-120 min	2,30 €
		Hora adicional	4,00 €
		No abonados
		0-60 min	2 €	
		61-120 min	6€
		Hora adicional	4,00 €
		Coger bici en una base llena (>70%) o Devolverla en una base vacía (<30%)
		Descuento de -0,10 €
*
*/
	public static void main(String[] args) {
		
		//METODOS USER
		
		/*Todos los metodos trabajan sobre el directorio "res/users.bin", si se quisiese cambiar se deberia ir a la clase AleatorioUser 
		y cambiar la constante userRandomFile por la ruta del fichero en el cual se quiera trabajar
		
		El fichero desde el cual se hace la carga inicial del fichero aleatorio es "res/users.csv" , esta información se encuentra 
		en la clase AleatorioUser en la constante path_csv
		
		Instrucciones de uso:
		-Comentar todos los metodos menos loadUserCSV para iniciar un fichero aleatorio con 5 registros de prueba que contiene "res/User.csv"
		-Una vez iniciado Users.bin podemos comentar el metodo loadUserCSV y probar todos los metodos de lectura y escritura del fichero aleatorio
		*/
		
		//Serializable
		Order order = new Order(1,2,20.0,"19febrero","3 de enero","4marzo","2enero");
		order.setBikeKey(1);
		order.setUserKey(2);
		order.setTotalCost(20.0);
		order.setEndTime("2 de enero");
		order.setEndTotem("3 de enero");
		order.setStartTime("4 marzo");
		order.setStartTotem("19 febrero");
		
		
		SerializableBike sb = new SerializableBike();
		
		sb.addOrder(order, Paths.get("res/Serializable.bin"));
		
		
		//Aleatorio
		AleatorioUser aleatorioUser = new AleatorioUser();
		BikeRandom aleatorioBike = new BikeRandom();
		
	
		//Variables para usar el menu
		int id_user=7, id_borrado=3,id_creditadd=1,id_creditremove=1, id_bici=1,id_borrado_bici=3,id_modificado_bici=3;
		double creditadd=10, creditremove=5;
		
		//Usuario para modificar cambiar id_user segun el usuario
		User usuario = new User(id_user, "Fulanito", "Apellido","12345678q", true, "calle de prueba", 10);
		
		int opc = 0;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nMenu Gestion Usuarios\n");
			System.out.println("1.Cargar Fichero Usuarios Acceso Aleatorio desde 'res/users.csv'\n"
					+ "2.Insertar usuario\n"
					+ "3.Borrar usuario\n"
					+ "4.Modificar usuario\n"
					+ "5.Añadir credito\n"
					+ "6.Quitar credito\n"
					+ "7.Mostrar un usuario\n"
					+ "8.Mostrar todos los usuarios\n"
					+ "\nMenu Gestion Bicis\n\n"
					+ "9.Cargar Fichero Bicis Acceso Aleatorio desde 'res/bike.csv'\n"
					+ "10.Borrar bici\n"
					+ "11.Modificar bici\n"
					+ "12.Mostrar una bici\n"
					+ "13.Mostar todas las bicis\n"
					+ "14.Salir\n");
			
			opc = in.nextInt();
			switch (opc) {
			case 1:
				aleatorioUser.loadUserCSV();
				System.out.println("Fichero usuarios iniciado");
				break;
			case 2:
				aleatorioUser.saveUser(usuario);
				System.out.println("Guardado usuario "+usuario.toString());
				break;
			case 3:
				aleatorioUser.deleteUser(id_borrado);
				System.out.println("Borrado usuario "+id_borrado);
				break;
			case 4:
				aleatorioUser.modifyUser(usuario);
				System.out.println("Modificado usuario "+usuario.toString());
				break;
			case 5:
				aleatorioUser.addCredit(id_creditadd, creditadd);
				System.out.println("Añadido "+creditadd+"€ al usuario id="+id_creditadd);
				break;
			case 6:
				aleatorioUser.removeCredit(id_creditremove, creditremove);
				System.out.println("Añadido "+creditremove+"€ al usuario id="+id_creditremove);
				break;
			case 7:
				User userid = aleatorioUser.getUser(2);
				//Lista el usuario obtenido en el metodo getUser
				System.out.println(userid);
				break;
			case 8:
				ArrayList<User> users = aleatorioUser.getAllUsers();
				// Lista todos los usarios devuelto con el metodo aleatorio.getAllUsers();
				for(User user:users){
					System.out.println(user);
				}
				break;
			case 9:
				aleatorioBike.loadBikeCSV(Paths.get("res/bike.csv"),Paths.get("res/bike.bin"));
				System.out.println("Fichero bicis iniciado");
				break;
			case 10:
				aleatorioBike.deleteBike(id_borrado_bici);
				System.out.println("Borrada bici "+id_borrado);
				break;
			case 11:
				aleatorioBike.modifyBike(id_modificado_bici);
				System.out.println("Modificada bici "+id_modificado_bici);
				break;
			case 12:
				Bike bici_id= aleatorioBike.getBike(id_bici,Paths.get("res/bike.bin"));
				System.out.println(bici_id.toString());
				break;
			case 13:
				ArrayList<Bike> bicis = aleatorioBike.getAllBikes(Paths.get("res/bike.bin"));
				for(Bike bici:bicis){
					System.out.println(bici.toString());
				}
				break;
			case 14:
				System.exit(0);
				break;
			default:
				break;
			}
		}
	
	}

}
