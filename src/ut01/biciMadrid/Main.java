package ut01.biciMadrid;

import java.nio.file.Path;
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
		BikeRandom aleatorio = new BikeRandom();
		//aleatorio.loadBikeCSV(Paths.get("res/bike.csv"),
				//Paths.get("res/bike.bin"));
		
		
		/*Este es el metodo de borrar*/
		aleatorio.deleteBike(3);
		//ArrayList<Bike> bicis = aleatorio.getAllBikes(Paths.get("res/bike.bin"));
		
		//Metodo de modificicar
		//aleatorio.modifyBike(3);
		//ArrayList<Bike> bicis = aleatorio.getAllBikes(Paths.get("res/bike.bin"));
		
		//Metodo obtener bici
		//aleatorio.getBike(2,Paths.get("res/bike.bin"));
		
		/*for(Bike bici:bicis){			
			if(bici.getKey()==(2)){
			System.out.println(bici.toString());
			}
		}*/
		ArrayList<Bike> bicis = aleatorio.getAllBikes(Paths.get("res/bike.bin"));
		for(Bike bici:bicis){
			System.out.println(bici.toString());
		}
	
		//int userKey, int bikeKey, double totalCost, String startTotem, String endTotem, String startTime,
		//String endTime
		Order order = new Order(1,2,20.0,"19febrero","3 de enero","4marzo","2enero");
	/*	order.setBikeKey(1);
		order.setUserKey(2);
		order.setTotalCost(20.0);
		order.setEndTime("2 de enero");
		order.setEndTotem("3 de enero");
		order.setStartTime("4 marzo");
		order.setStartTotem("19 febrero");*/
		
		
		SerializableBike sb = new SerializableBike();
		
		sb.addOrder(order, Paths.get("res/Serializable.bin"));
		
	}

}

