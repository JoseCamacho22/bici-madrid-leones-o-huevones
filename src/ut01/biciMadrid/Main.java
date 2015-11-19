package ut01.biciMadrid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.ArrayList;

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
		AleatorioUser aleatorio = new AleatorioUser();
		aleatorio.loadUserCSV(Paths.get("res/users.bin"));
		
		
		/*User usuario = new User(999, "Fulanito", "Apellido","12345678q", true, "calle de prueba", 10);
		aleatorio.saveUser(usuario, Paths.get("res/users.bin"));*/
		
		//User userDni = aleatorio.getUser(Paths.get("res/users.bin"), "12131231t");
		
		//System.out.println(userDni);
		//ArrayList<User> users = aleatorio.getAllUsers(userRandomFile)(Paths.get("res/users.bin"), "12131231t");
		/*try (RandomAccessFile raf = new RandomAccessFile(userRandomFile.toFile(), "rw")) {
			int position = (1 - 1) * 191;
			raf.seek(position);
			User userVacio = new User(8,"","","",false,"",0);
			System.out.println("prueba");
			saveUser(userVacio, userRandomFile);
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("error2");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("error1");
	}
		*/
		aleatorio.deleteUser(5);
		ArrayList<User> users = aleatorio.getAllUsers(Paths.get("res/users.bin"));
		for(User user:users){
			System.out.println(user);
		}
	}

}
