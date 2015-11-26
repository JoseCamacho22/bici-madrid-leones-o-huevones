package ut01.biciMadrid;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.ArrayList;

public interface InterfaceRandomUser {
	
	public void loadUserCSV(); //Carga inicial del fichero aleatorio desde un csv
	
	public User getUser(int key); //Devuelve un objeto del tipo User con el id que se le pase
	
	public void saveUser(User user); //Escribe un usuario en el registro
	
	public void deleteUser(int key); //Borra un usuario por su id
	
	public void modifyUser(User user); //Modifica todos los campos de un usuario
	
	public void addCredit(int key, double credit); // Añade credito a un usuario por su id
	
	public void removeCredit(int key, double credit); //Quita credito a un usuario por su id
	
	public ArrayList<User> getAllUsers(); // Devuelve un ArrayList con todos los usuarios
	
}
