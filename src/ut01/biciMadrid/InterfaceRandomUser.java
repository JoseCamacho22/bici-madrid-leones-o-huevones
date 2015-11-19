package ut01.biciMadrid;

import java.nio.file.Path;

public interface InterfaceRandomUser {
	
   
	
	void loadUserCSV(Path csvUserFile, Path userRandomFile);


    public  User getUser(String dni, Path userRandomFile);
	
	public void saveUser(User user, Path userRandomFile);
	
	public void deleteUser(int key, Path userRandomFile);

	public User modifyUser(String dni, Path userRandomFile);
	
	public User addCredit(String dni, double credit, Path userRandomFile);

	public User removeCredit(String dni, double credit, Path userRandomFile);

	
	
	public java.util.ArrayList<User> getAllUsers(Path userRandomFile);
	


}
