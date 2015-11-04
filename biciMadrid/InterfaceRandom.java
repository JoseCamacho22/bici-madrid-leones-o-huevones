package ut01.biciMadrid;

import java.nio.file.Path;

public interface InterfaceRandom {
	
    
	void loadBikeCSV(Path csvBikeFile, Path bikeRandomFile);
	
	void loadUserCSV(Path csvUserFile, Path userRandomFile);


	public  Bike getBike(int key, Path bikeRandomFile);
	
	public void saveBike(Bike bici, Path bikeRandomFile);
	
	public Bike deleteBike(int key, Path bikeRandomFile);

	public Bike modifyBike(Bike bici, Path bikeRandomFile);
	
	public java.util.ArrayList<Bike> getAllBikes(Path bikeRandomFile);
	
    public  User getUser(String dni, Path userRandomFile);
	
	public void saveUser(User user, Path userRandomFile);
	
	public User deleteUser(String dni, Path userRandomFile);

	public User modifyUser(String dni, Path userRandomFile);
	
	public User addCredit(String dni, double credit, Path userRandomFile);

	public User removeCredit(String dni, double credit, Path userRandomFile);

	
	
	public java.util.ArrayList<User> getAllUsers(Path userRandomFile);
	


}
