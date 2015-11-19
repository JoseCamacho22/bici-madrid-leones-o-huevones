package ut01.biciMadrid;

import java.nio.file.Path;

public interface InterfaceRandomTotem {

	
	void loadTotemCSV(Path csvTotemFile, Path TotemRandomFile);

	public Totem getTotem(int key, Path TotemRandomFile);

	public void saveTotem(Totem bici, Path TotemRandomFile);

	public Totem deleteTotem(int key, Path TotemRandomFile);

	public Totem modifyTotem(Totem bici, Path TotemRandomFile);

	public java.util.ArrayList<Totem> getAllTotems(Path TotemRandomFile);
	
	

}