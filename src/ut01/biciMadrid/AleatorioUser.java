package ut01.biciMadrid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AleatorioUser implements InterfaceRandomUser {

	final static int CAMPO_KEY = 0;
	final static int CAMPO_NAME = 1;
	final static int CAMPO_LASTNAME = 2;
	final static int CAMPO_DNI = 3;
	final static int CAMPO_SUBSCRIBER = 4;
	final static int CAMPO_ADDRESS = 5;
	final static int CAMPO_CREDIT = 6;
	final static int RECORD_USER = 191;
	final static int MAX_USERS = 1000;
	final static int TAM_NAME = 20;
	final static int TAM_LAST_NAME = 20;
	final static int TAM_DNI = 9;
	final static int TAM_ADDRESS = 40;
	
	
	
	public void loadUserCSV(Path userRandomFile) {
		Path path = Paths.get("res/usuarios.csv");
		loadUserCSV(path, userRandomFile);
	}

	
	@Override
	public void loadUserCSV(Path csvUserFile, Path userRandomFile) {
		// TODO Auto-generated method stub
		String line;
		try (BufferedReader br = Files.newBufferedReader(csvUserFile, Charset.forName("UTF-8"))) {
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				User user = getUser(fields);
				if (user.getKey() > 0)// comprobamos que es un usuario válido
					saveUser(user, userRandomFile);
			}

		} catch (IOException e) {
			System.err.println("Error I/O al cargar CSV ");

		}
	}
	
	private User getUser(String[] fields) {
		User user = new User();

		try {
			user = new User(Integer.parseInt(fields[CAMPO_KEY]), (fields[CAMPO_NAME]),(fields[CAMPO_LASTNAME]),(fields[CAMPO_DNI]), 
					Boolean.parseBoolean((fields[CAMPO_SUBSCRIBER])),(fields[CAMPO_ADDRESS]), Double.parseDouble((fields[CAMPO_CREDIT])));
		} catch (NumberFormatException e) {
			//System.err.println("Error al convertir el campo ");

		}
		return user;
	}

	
	@Override
	public User getUser(String dni, Path userRandomFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user, Path userRandomFile) {
		// TODO Auto-generated method stub
		int position = 0;
		try (RandomAccessFile raf = new RandomAccessFile(userRandomFile.toFile(), "rw")) {

			position = (user.getKey() - 1) * RECORD_USER;
			if (position < MAX_USERS * RECORD_USER) {
				raf.seek(position);
				writeUserRecord(raf, user);
			} else
				System.out.println("Registro no valido");

		} catch (FileNotFoundException e) {
			System.err.format("No encuentra el fichero %s", userRandomFile.getFileName());

		} catch (IOException e) {
			System.err.format("Error I/O al escribir el aleatorio de usuarios");

		}
	}
	
	public void writeUserRecord(RandomAccessFile raf, User user) throws IOException {
		// TODO Auto-generated method stub
			raf.writeInt(user.getKey());//escribimos key
			
			StringBuilder sbName = new StringBuilder(user.getName());
			sbName.setLength(TAM_NAME);
			raf.writeChars(sbName.toString());//escribimos name
			
			StringBuilder sbLastName = new StringBuilder(user.getLast_name());
			sbLastName.setLength(TAM_LAST_NAME);
			raf.writeChars(sbLastName.toString());//escribimos last name
			
			StringBuilder sbDni = new StringBuilder(user.getDni());
			sbDni.setLength(TAM_DNI);
			raf.writeChars(sbDni.toString());//escribimos dni
			
			raf.writeBoolean(user.isSubscriber());//escribimos suscribber
			
			StringBuilder sbAddress = new StringBuilder(user.getAddress());
			sbAddress.setLength(TAM_ADDRESS);
			raf.writeChars(sbAddress.toString());//escribimos address
			
			raf.writeDouble(user.getCredit());//escribimos credit
		
	}

	
	@Override
	public User deleteUser(String dni, Path userRandomFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User modifyUser(String dni, Path userRandomFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addCredit(String dni, double credit, Path userRandomFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeCredit(String dni, double credit, Path userRandomFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers(Path userRandomFile) {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<>();
		int key;
		boolean subscrib;
		double credit;
		char name[] = new char[TAM_NAME], auxName, lastname[]= new char[TAM_LAST_NAME], auxLastName, dni[]=new char[TAM_DNI]
				, auxDni, address[] = new char[TAM_ADDRESS], auxAddress;
		
		try (RandomAccessFile raf = new RandomAccessFile(userRandomFile.toFile(), "r")) {
			do{
				key= raf.readInt();//Leemos key
				
				for(int i=0; i<TAM_NAME;i++){//leemos nombre
					auxName = raf.readChar(); 
					if((int) auxName !=0){
						name[i]=auxName;
					}
					else{
						name[i] =' ';
					}
				}
				String nameS = new String(name);
				
				for(int i=0; i<TAM_LAST_NAME;i++){//leemos apellido
					auxLastName = raf.readChar(); 
					if((int) auxLastName !=0){
						lastname[i]=auxLastName;
					}
					else{
						lastname[i] =' ';
					}
				}
				String lastnameS = new String(lastname);
				
				for(int i=0; i<TAM_DNI;i++){//leemos dni
					auxDni = raf.readChar(); 
					if((int) auxDni !=0){
						dni[i]=auxDni;
					}
					else{
						dni[i] =' ';
					}
				}
				String dniS = new String(dni);
				
				subscrib= raf.readBoolean();//leemos subscripción
				
				for(int i=0; i<TAM_ADDRESS;i++){//leemos dirección
					auxAddress = raf.readChar(); 
					if((int) auxAddress !=0){
						address[i]=auxAddress;
					}
					else{
						address[i] =' ';
					}
				}
				String addressS = new String(address);
				
				credit= raf.readDouble();
				
				User user = new User(key, nameS, lastnameS, dniS, subscrib, addressS, credit);
				users.add(user);
				System.out.println("raf.getFilePointer()= "+raf.getFilePointer()+" raf.length()= "+raf.length());
			}
			
			while (raf.getFilePointer() < 954);
			

		} catch (FileNotFoundException e) {
			System.err.format("No encuentra el fichero %s", userRandomFile.getFileName());

		} catch (IOException e) {
			System.err.format("Error I/O al leer el aleatorio de bicis");

		}

		return users;
	}

}