package ut01.biciMadrid;

import java.nio.file.Path;

public interface InterfaceRandomBike {
	
    
	void loadBikeCSV(Path csvBikeFile, Path bikeRandomFile);
	


	public  Bike getBike(int key, Path bikeRandomFile);
	
	public void saveBike(Bike bici, Path bikeRandomFile);
	
	public Bike deleteBike(int key, Path bikeRandomFile);

	public Bike modifyBike(Bike bici, Path bikeRandomFile);
	
	public java.util.ArrayList<Bike> getAllBikes(Path bikeRandomFile);
	
    


}
