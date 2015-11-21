package ut01.biciMadrid;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public interface InterfaceRandomUser {
	
   
	
	void loadUserCSV(Path csvUserFile, Path userRandomFile);

    public  User getUser(int key, Path userRandomeFile, RandomAccessFile raf ) throws IOException;
	
	public void saveUser(User user, Path userRandomFile);
	
	public void deleteUser(int key, Path userRandomFile);

	public void modifyUser(User user, Path userRandomFile);
	
	public void addCredit(int key, double credit, Path userRandomFile);

	public void removeCredit(int key, double credit, Path userRandomFile);

	
	
	public java.util.ArrayList<User> getAllUsers(Path userRandomFile);
	


}
