package ut01.biciMadrid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import ut01.biciMadrid.*;
public class SerializableBike implements InterfaceSerializable {

	@Override
	public void addOrder(Order order, Path serializableFile) {
		// TODO Auto-generated method stub
		try (ObjectOutputStream dataOS = new ObjectOutputStream(Files.newOutputStream(serializableFile))) {

			// escribo en el fichero
			dataOS.writeObject(order); 

		} catch (FileNotFoundException fnfe) {
			System.err.println("El fichero " + serializableFile.getFileName() + " no se encuentra");
		} catch (IOException ioe) {
			System.err.println("Error de E/S"+ioe.getMessage());
		}

	}

	@Override
	public Order getUserOrders(int userKey, Path serializableFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getAllOrders(Path Serializable) {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<>();
	/*	 FileInputStream fis = null;
		ArrayList<Order> orders = new ArrayList<>();

		try{
		
		fis=new FileInputStream(Serializable.toFile());
		 ObjectInputStream entrada = null;
		 entrada=new ObjectInputStream(fis);
		 Order order=entrada.readObject((int)order.getUserKey(),(int)order.getBikeKey(),(double)order.getTotalCost(),order.getStartTotem(),
				 order.getEndTotem(),order.getStartTime(),order.getEndTime());
		} catch (FileNotFoundException e) {
			System.err.format("No encuentra el fichero %s", Serializable.getFileName());

		} catch (IOException e) {
			System.err.format("Error I/O al leer el aleatorio de bicis");

		}*/

		return orders;
	}


}
