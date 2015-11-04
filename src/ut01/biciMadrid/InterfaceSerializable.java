package ut01.biciMadrid;

import java.nio.file.Path;
import java.util.ArrayList;

public interface InterfaceSerializable {

	void addOrder(Order order, Path serializableFile);
	
	Order getUserOrders(int userKey , Path serializableFile);

	ArrayList<Order> getAllOrders(Path serializableFile);

}
