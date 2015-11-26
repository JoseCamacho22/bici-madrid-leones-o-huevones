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
		/*Todos los metodos trabajan sobre el directorio "res/users.bin", si se quisiese cambiar se deberia ir a la clase AleatorioUser 
		y cambiar la constante userRandomFile por la ruta del fichero en el cual se quiera trabajar
		
		El fichero desde el cual se hace la carga inicial del fichero aleatorio es "res/users.csv" , esta información se encuentra 
		en la clase AleatorioUser en la constante path_csv
		
		Instrucciones de uso:
		-Comentar todos los metodos menos loadUserCSV para iniciar un fichero aleatorio con 5 registros de prueba que contiene "res/User.csv"
		-Una vez iniciado Users.bin podemos comentar el metodo loadUserCSV y probar todos los metodos de lectura y escritura del fichero aleatorio
		*/
		
		//Creacion del objeto para lanzar los metodos
		AleatorioUser aleatorio = new AleatorioUser();
		
		//Inicia Fichero aleatorio con los datos de "res/Users.csv
		aleatorio.loadUserCSV();
		
		/*Creación de usuario para insertarlo en la 
		posicion 7 del fichero aleatorio, cambiar primer campo para insertarlo en otra posicon*/
		User usuario = new User(7, "Fulanito", "Apellido","12345678q", true, "calle de prueba", 10);
		
		//Insertar usuario
		aleatorio.saveUser(usuario);
		
		//Borrar usuario por id
		aleatorio.deleteUser(3);
		
		/*Modificar usuario completo, tener en cuanto que es simplemente un metodo de sobre-escritura, importante 
		respetar el id del usuario a modificar*/
		aleatorio.modifyUser(usuario);
		
		//Añadir credito (id usuario, credito a añadir)
		aleatorio.addCredit(1, 10);
		
		//Quitar credito(id usuario, credito a restar)
		aleatorio.removeCredit(1, 5);
		
		//Devuelve un objeto del tipo usuario
		User userid = aleatorio.getUser(2);
		
		//Lista el usuario obtenido en el metodo getUser
		System.out.println(userid);
		
		//Devuelve un arraylist de todos los usuarios
		ArrayList<User> users = aleatorio.getAllUsers();
		
		// Lista todos los usarios devuelto con el metodo aleatorio.getAllUsers();
		for(User user:users){
			System.out.println(user);
		}
	}

}
