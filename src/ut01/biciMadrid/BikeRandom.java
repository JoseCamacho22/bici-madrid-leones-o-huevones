package ut01.biciMadrid;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Spliterator;

/**
 * 
 * @authors
 * Miguel Angel Garcia,Jose Augusto Camacho,Ivan Sanchez Gomez 
 *
 */

public class BikeRandom implements InterfaceRandomBike {

	final static int RECORD_BIKE = 10; // dos int (4) y dos boolean (1)
	final static int MAX_BIKES = 500; // dos int y dos boolean

	public void loadBikeCSV(Path bikeRandomFile) {
		Path path = Paths.get("res/bike.csv");
		loadBikeCSV(path, bikeRandomFile);
	}

	@Override
	public void loadBikeCSV(Path csvBikeFile, Path bikeRandomFile) {
		String line;
		try (BufferedReader br = Files.newBufferedReader(csvBikeFile, Charset.forName("UTF-8"))) {
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				Bike bike = getBike(fields);
				if (bike.getKey() > 0)// comprobamos que es una bici v√°lida
					saveBike(bike, bikeRandomFile);
			}

		} catch (IOException e) {
			System.err.println("Error I/O al cargar CSV ");

		}

	}
	

	
	
	private Bike getBike(String[] fields) {
		Bike bike = new Bike();
     //Con esto se salta el primer campo
		try {
			bike = new Bike(Integer.parseInt(fields[0]), Boolean.parseBoolean(fields[1]),
					Boolean.parseBoolean(fields[2]), Integer.parseInt(fields[3]));
		} catch (NumberFormatException e) {
			System.err.println("");

		}
		return bike;
	}

	
	@Override
	public Bike getBike(int key, Path bikeRandomFile) {
		RandomAccessFile streamIn = null;
		Bike bici = new Bike(2, true, false, 4);

		try {
			streamIn = new RandomAccessFile(bikeRandomFile.toFile(), "r");
																																					
			int position = (key-1) * RECORD_BIKE; 
			streamIn.seek(position);
			if (position < streamIn.length()) {												
				leerRegistro(streamIn);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {

		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
				}
		}

		return bici;
		
	}
	
	

	private Bike leerRegistro(RandomAccessFile streamIn) throws IOException {
	
			// TODO ApÈndice de mÈtodo generado autom·ticamente

			int id;
			boolean activa;
			boolean alquilada;
			int idTotem;
			
			id = streamIn.readInt();
			activa = streamIn.readBoolean();
			alquilada = streamIn.readBoolean();
			idTotem = streamIn.readInt();

			Bike bici = new Bike(id, activa, alquilada, idTotem);

			return bici;
		}

	

	@Override
	public void saveBike(Bike bici, Path bikeRandomFile) {
		int position = 0;
		try (RandomAccessFile raf = new RandomAccessFile(bikeRandomFile.toFile(), "rw")) {

			position = (bici.getKey() - 1) * RECORD_BIKE;
			if (position < MAX_BIKES * RECORD_BIKE) {
				raf.seek(position);
				writeBikeRecord(raf, bici);
			} else
				System.out.println("Registro no valido");

		} catch (FileNotFoundException e) {
			System.err.format("No encuentra el fichero %s", bikeRandomFile.getFileName());

		} catch (IOException e) {
			System.err.format("Error I/O al escribir el aleatorio de bicis");

		}

	}

	private void writeBikeRecord(RandomAccessFile raf, Bike bici) throws IOException {

		raf.writeInt(bici.getKey());
		raf.writeBoolean(bici.isActiva());
		raf.writeBoolean(bici.isAlquilada());
		raf.writeInt(bici.getTotem());

	}

	
	public void deleteBike(int key) {
		Path path = Paths.get("res/bike.bin");
		deleteBike(key, path);
		
	}
	
	@Override
	public void deleteBike(int key, Path bikeRandomFile) {
		// TODO Auto-generated method stub
		
		RandomAccessFile streamOut = null;
		int position = (key-1) * BikeRandom.RECORD_BIKE;
		try {
				streamOut = new RandomAccessFile(bikeRandomFile.toFile(), "rw");						
				streamOut.seek(position);
				Bike biciElim = new Bike(0, false, false, 0);
				writeBikeRecord(streamOut, biciElim);

			} catch (FileNotFoundException e) {
				} catch (IOException e) {

		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					
				}
		}


		
		
	}
	
	public void modifyBike(int key){
		Path path = Paths.get("res/bike.bin");
		Bike biciModifica=new Bike(3,true,false,15); 
		modifyBike(biciModifica,path);
	
		
	}

	@Override
	public Bike modifyBike(Bike bici, Path bikeRandomFile) {
		// TODO Auto-generated method stub
		
		RandomAccessFile streamOut = null;

		try {
			streamOut = new RandomAccessFile(bikeRandomFile.toFile(), "rw");
			int position = (bici.getKey() - 1) * RECORD_BIKE;
			if (position < streamOut.length()) {
				streamOut.seek(position);			
				writeBikeRecord(streamOut,bici);
			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero"+bikeRandomFile.getFileName()+"No se encuentra ");
		} catch (IOException e) {
			System.err.println("Error de entrada y salida de datos");
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error de entrada y salida ");
				}
		}
		return bici;
		
		
		
	}

	@Override
	public ArrayList<Bike> getAllBikes(Path bikeRandomFile) {
		ArrayList<Bike> bicis = new ArrayList<>();

		try (RandomAccessFile raf = new RandomAccessFile(bikeRandomFile.toFile(), "r")) {
			while (raf.getFilePointer() < raf.length()) {
				Bike bici = new Bike(raf.readInt(), 
						raf.readBoolean(),
						raf.readBoolean(), 
						raf.readInt());
				bicis.add(bici);
			}

		} catch (FileNotFoundException e) {
			System.err.format("No encuentra el fichero %s", bikeRandomFile.getFileName());

		} catch (IOException e) {
			System.err.format("Error I/O al leer el aleatorio de bicis");

		}

		return bicis;
	}
	
	
	

	
}
