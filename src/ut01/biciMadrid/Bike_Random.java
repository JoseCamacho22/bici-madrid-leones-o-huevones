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

public class Bike_Random implements InterfaceRandomBike {

	final static int RECORD_BIKE = 10; // dos int (4) y dos boolean (1)
	final static int MAX_BIKES = 500; // dos int y dos boolean

	public void loadBikeCSV(Path bikeRandomFile) {
		Path path = Paths.get("res/bike.csv");
		loadBikeCSV(path, bikeRandomFile);
	}

	@Override
	public void loadBikeCSV(Path csvBikeFile, Path bikeRandomFile) {
		String line;
		
		//leo el fichero con el metodo Files BufferedReader.
		try (BufferedReader br = Files.newBufferedReader(csvBikeFile, Charset.forName("UTF-8"))) {
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");//reconoce hasta la coma tanto el split como tokenizer
				//StringTokenizer st =new StringTokenizer(record, ",");
				Bike bike = getBike(fields);
				if (bike.getKey() > 0)// comprobamos que es una bici válida
					saveBike(bike, bikeRandomFile);
			}

		} catch (IOException e) {
			System.err.println("Error I/O al cargar CSV ");

		}

	}

	private Bike getBike(String[] fields) {
		Bike bike = new Bike();

		try {
			bike = new Bike(Integer.parseInt(fields[0]), Boolean.parseBoolean(fields[1]),
					Boolean.parseBoolean(fields[2]), Integer.parseInt(fields[3]));
		} catch (NumberFormatException e) {
			System.err.println();

		}
		return bike;
	}

	
	@Override
	public Bike getBike(int key, Path bikeRandomFile) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Bike deleteBike(int key, Path bikeRandomFile) {
		// TODO Auto-generated method stub
		
		
		return null;
		
	}

	@Override
	public Bike modifyBike(Bike bici, Path bikeRandomFile) {
		// TODO Auto-generated method stub
		return null;
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